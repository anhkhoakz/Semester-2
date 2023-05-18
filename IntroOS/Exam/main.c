#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <omp.h>

#define SEED 200
#define UPPER_LIM 1000
#define LOWER_LIM 1

// Function declarations
int generate_random_number(unsigned int lower_limit, unsigned int upper_limit);
void merge_data(int n1, int n2, int *a1, int *a2, int *a3, int n3);
void save_data_to_file(const char *filename, int n, int *a);
void send_message(int msgid, int mesg_type, int n, int *a);

int main(int argc, char *argv[]) {
  // Parse command-line arguments
  int n = atoi(argv[1]);
  int n1 = n / 2;
  int n2 = n - n1;

  // Initialize the two arrays in parallel using OpenMP
  int *a1 = (int *)malloc(n1 * sizeof(int));
  int *a2 = (int *)malloc(n2 * sizeof(int));
#pragma omp parallel for
  for (int i = 0; i < n1; i++) {
    a1[i] = generate_random_number(LOWER_LIM, UPPER_LIM);
  }
#pragma omp parallel for
  for (int i = 0; i < n2; i++) {
    a2[i] = generate_random_number(LOWER_LIM, UPPER_LIM);
  }

  // Merge the two arrays into one
  int *a3 = (int *)malloc(n * sizeof(int));
  merge_data(n1, n2, a1, a2, a3, n);

  // Save the merged array to file
  save_data_to_file("init_data", n, a3);

  // Send the merged array to another process via a message queue
  key_t key = ftok(".", 'q');
  int msgid = msgget(key, 0666 | IPC_CREAT);
  if (msgid == -1) {
    perror("msgget");
    exit(EXIT_FAILURE);
  }
  send_message(msgid, 1, n, a3);

  // Free memory allocated for the arrays
  free(a1);
  free(a2);
  free(a3);

  return 0;
}

int generate_random_number(unsigned int lower_limit, unsigned int upper_limit) {
  return rand() % (upper_limit - lower_limit + 1) + lower_limit;
}

void merge_data(int n1, int n2, int *a1, int *a2, int *a3, int n3) {
  int i, j, k;
  for (i = 0, j = 0, k = 0; i < n1 && j < n2;) {
    if (a1[i] < a2[j]) {
      a3[k++] = a1[i++];
    } else {
      a3[k++] = a2[j++];
    }
  }
  while (i < n1) {
    a3[k++] = a1[i++];
  }
  while (j < n2) {
    a3[k++] = a2[j++];
  }
}

void save_data_to_file(const char *filename, int n, int *a) {
  FILE *fp = fopen(filename, "w");
  if (fp == NULL) {
    printf("Cannot open file.\n");
    return;
  }
  for (int i = 0; i < n; i++) {
    fprintf(fp, "%d ", a[i]);
  }
  fclose(fp);
}

void send_message(int msgid, int mesg_type, int n, int *a) {
  struct message {
    long mesg_type;
    int n;
    int *a;
  } msg;

  msg.mesg_type = mesg_type;
  msg.n = n;
  msg.a = a;

  if (msgsnd(msgid, &msg, sizeof(msg.n) + sizeof(int) * n, 0) == -1) {
    perror("msgsnd");
    exit(EXIT_FAILURE);
  }
}