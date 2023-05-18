

#include <pthread.h>

#include <stdio.h>

#define NUMTHREADS 5
int main(int argc, char *argv[])
{
  int i, policy;
  pthread_t tid[NUMTHREADS];
  pthread_attr_t attr;
  /* get the default attributes */
  pthread_attr_init(&attr);
  /* get the current scheduling policy */
  if (pthread_attr_getschedpolicy(&attr, &policy) != 0)
    fprintf(stderr, "Unable to get policy.∖n");
  else
  {
    if (policy == SCHED_OTHER)
      printf("SCHED_OTHER∖n");
    else if (policy == SCHED_RR)
      printf("SCHED_RR∖n");
    else if (policy == SCHED_FIFO)
      printf("SCHED_FIFO∖n");
  }
  /* set the scheduling policy - FIFO, RR, or OTHER */
  if (pthreadattrsetschedpolicy(&attr, SCHEDFIFO) != 0)
    fprintf(stderr, "Unable to set policy.∖n");
  /* create the threads */
  for (i = 0; i < NUMTHREADS; i++)
    pthread_create(&tid[i], &attr, runner, NULL);
  /* now join on each thread */
  for (i = 0; i < NUMTHREADS; i++)
    pthread_join(tid[i], NULL);
}
/* Each thread will begin control in this function */
void *runner(void *param)
{
  /* do some work ... */
  pthread_exit(0);
}
