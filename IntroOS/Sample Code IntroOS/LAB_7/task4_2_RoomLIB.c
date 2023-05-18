// 2021 June 12
// Author: Tran Trung Tin. Demo in [1] page 266
// Demo using memory barrier to make a point.
#define _GNU_SOURCE

#include <pthread.h>

#include <stdio.h>

#include <stdlib.h>

#include <unistd.h> // for sleep()

#include <stdbool.h>

#include <stdatomic.h>

void *urgent(void *param);    /* threads call this function */
void *interrupt(void *param); /* threads call this function */
atomic_bool flag = false;

int main(int argc, char *argv[])
{

  pthread_t tid[2];    /* the thread identifier */
  pthread_attr_t attr; /* set of thread attributes */
  /* set the default attributes of the thread */
  pthread_attr_init(&attr);
  /* create the thread */
  pthread_create(&tid[0], &attr, urgent, argv[1]);
  pthread_create(&tid[1], &attr, interrupt, argv[1]);
  /* wait for the thread to exit */
  for (int i = 0; i < 2; i++)
    pthread_join(tid[i], NULL);

  return 0;
}
/* The thread will execute in this function */
void *urgent(void *param)
{
  if (atomic_flag_test_and_set(&flag) == 0)
  {
    printf("\nA: Urgent in %d sec ...", atoi(param));
    sleep(atoi(param)); // try after interval 1 sec
  }
  printf("\nA: I'm done.");
  atomic_flag_clear(&flag);
  pthread_exit(0);
}

/* The thread will execute in this function */
void *interrupt(void *param)
{
  sleep(1); // come late.
  while (atomic_flag_test_and_set(&flag) == 1)
  {
    printf("\nB: I'm waiting ...");
    sleep(1); // try after interval 1 sec
  }
  printf("\nB: I'm in ....\n");
  atomic_flag_clear(&flag);
  pthread_exit(0);
}
