// 2021 June 2
// Author: Tran Trung Tin
// Demo using gen random matrix and write to file
#include <pthread.h>

#include <stdio.h>

#include <stdlib.h>

#include <string.h>

#include <stdint.h>
#define M 10
#define N 10
#define MAX_INT 10000
#define MAX_LENGTH 100
struct matrix
{
  int a[M][N];
  char *filename;
};

void *writer(void *param);
void *reader(void *param);
int main(int argc, char *argv[])
{
  pthread_t tid;       /* the thread identifier */
  pthread_attr_t attr; /* set of thread attributes */
  /* set the default attributes of the thread */
  pthread_attr_init(&attr);
  void *status;
  struct matrix A, B;

  A.filename = argv[1];
  /* create the thread */
  pthread_create(&tid, &attr, reader, (void *)&A);
  /* wait for the thread to exit */
  pthread_join(tid, &status);
  if ((intptr_t)status != -1)
  {
    pthread_create(&tid, &attr, writer, (void *)&A);
    /* wait for the thread to exit */
    pthread_join(tid, &status);
  }
  else
    printf("\nProgram exit");
  return 0;
}
/* The thread will execute in this function */
void *reader(void *param)
{
  struct matrix *fi = (struct matrix *)param;
  FILE *fp;
  if ((fp = fopen(fi->filename, "r")) == NULL)
  {
    printf("\nCannot open file.");
    return (void *)-1;
  }
  char line[MAX_LENGTH];
  char tokens[] = " \n";
  char *key;
  //   memset(line, 0, MAX_LENGTH);
  for (int i = 0; i < M; i++)
  {
    fgets(line, MAX_LENGTH, fp);
    key = (char *)strtok(line, tokens);
    int put1 = atoi(key);
    fi->a[i][0] = put1;
    for (int j = 1; j < N; j++)
    {
      key = (char *)strtok(NULL, tokens);
      int put2 = atoi(key);
      fi->a[i][j] = put2;
    }
  }
  fclose(fp);
  pthread_exit(0);
}

void *writer(void *param)
{
  struct matrix *fi = (struct matrix *)param;
  for (int i = 0; i < M; i++)
  {
    for (int j = 0; j < N; j++)
      fprintf(stdout, "%5d ", fi->a[i][j]);
    fprintf(stdout, "\r\n");
  }

  pthread_exit(0);
}
