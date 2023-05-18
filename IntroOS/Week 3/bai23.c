// 2021 June 2
// Author: Abraham Silberschatz  in book Operating System Concepts 8th Edition
// p.170 Demo using how to speed up sum of sequence integer.
#include <pthread.h>

#include <stdio.h>

#include <stdlib.h>

struct partition
{
  int start;
  int end;
};

void *songuyento(void *param);

struct partition A;
struct partition B;

// nguyên mẫu các hàm con

int main(int argc, char *argv[])
{
  if (argc < 2)
  {
    printf("Usage: %s <number>\n", argv[0]);
    return 1;
  }

  // xác định n
  int n = atoi(argv[1]);

  if (n < 2)
  {
    printf("So phai lon hon hoac bang 2\n");
    return 1;
  }
  // xác định phân đoạn A
  struct partition A = {2, n / 2};

  // xác định phân đoạn B
  struct partition B = {n / 2 + 1, n};

  pthread_t tid[2];    /* the thread identifier */
  pthread_attr_t attr; /* set of thread attributes */
  /* set the default attributes of the thread */
  pthread_attr_init(&attr);
  /* create the thread */
  pthread_create(&tid[0], &attr, songuyento, (void *)&A);
  pthread_create(&tid[1], &attr, songuyento, (void *)&B);
  /* wait for the thread to exit */
  pthread_join(tid[0], NULL);
  pthread_join(tid[1], NULL);
}

/* The thread will execute in this function */
void *songuyento(void *param)
{
  struct partition *X = (struct partition *)param;
  int start = X->start;
  int end = X->end;
  int i, j;
  int is_prime;
  for (i = start; i <= end; i++)
  {
    is_prime = 1;
    for (j = 2; j <= i / 2; j++)
    {
      if (i % j == 0)
      {
        is_prime = 0;
        break;
      }
    }
    if (is_prime)
    {
      printf("%d ", i);
    }
  }

  // nếu i là số nguyên tố thì in ra màn hình.
  pthread_exit(0);
}