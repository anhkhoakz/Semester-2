// 2021 June 7
// Author: Tran Trung Tin
// Atomic varible
#include <stdio.h>

#include <string.h>

#include <pthread.h>

#include <stdlib.h>

#include <unistd.h>

#include <stdatomic.h>

atomic_int acnt;
int cnt;

void *trythis(void *arg)
{
  int n;
  for (n = 0; n < 100; ++n)
  {
    ++cnt;
    ++acnt;
  }
  return 0;
}

int main(void)
{
  pthread_t tid[10];
  int i, error;
  for (i = 0; i < 10; ++i)
  {
    error = pthread_create(&(tid[i]), NULL, &trythis, NULL);
    if (error != 0)
      printf("\nThread can't be created : [%s]", strerror(error));
  }
  for (i = 0; i < 10; ++i)
    pthread_join(tid[i], NULL);

  printf("The atomic counter is %u\n", acnt);
  printf("The non-atomic counter is %u\n", cnt);
}
