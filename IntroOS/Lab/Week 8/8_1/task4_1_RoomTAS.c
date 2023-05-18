// 2021 June 12
// Author: Tran Trung Tin. Demo in [1] page 266
// Demo using memory barrier to make a point.
#define _GNU_SOURCE

#include <pthread.h>

#include <stdio.h>

#include <stdlib.h>

#include <unistd.h> // for sleep()

#include <stdbool.h>

pthread_mutex_t lock;
bool flag = false;

void *urgent(void *param);    /* threads call this function */
void *interrupt(void *param); /* threads call this function */

int main(int argc, char *argv[])
{
  pthread_t tid[2];    /* the thread identifier */
  pthread_attr_t attr; /* set of thread attributes */
  /* set the default attributes of the thread */
  pthread_attr_init(&attr);
  pthread_mutex_init(&lock, NULL);
  /* create the thread */
  pthread_create(&tid[0], &attr, urgent, argv[1]);
  pthread_create(&tid[1], &attr, interrupt, argv[1]);
  /* wait for the thread to exit */
  for (int i = 0; i < 2; i++)
  {
    pthread_join(tid[i], NULL);
  }
  pthread_mutex_destroy(&lock);
  return 0;
}

/* The thread will execute in this function */
void *urgent(void *param)
{
  pthread_mutex_lock(&lock);
  if (!flag)
  {
    flag = true;
    printf("\nA: Urgent in %d sec ...", atoi(param));
    sleep(atoi(param));
  }
  printf("\nA: I'm done.");
  flag = false;
  pthread_mutex_unlock(&lock);
  pthread_exit(0);
}

/* The thread will execute in this function */
void *interrupt(void *param)
{
  sleep(1); // come late.
  while (true)
  {
    pthread_mutex_lock(&lock);
    if (!flag)
    {
      flag = true;
      printf("\nB: I'm in ....\n");
      pthread_mutex_unlock(&lock);
      break;
    }
    pthread_mutex_unlock(&lock);
    printf("\nB: I'm waiting ...");
    sleep(1);
  }
  flag = false;
  pthread_exit(0);
}