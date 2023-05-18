
// Author:

#include <pthread.h>

#include <stdio.h>

#define NUMTHREADS 5
int main(int argc, char *argv[])
{
  int i, scope;
  pthread_t tid[NUMTHREADS];
  pthread_attr_t attr;
  /* get the default attributes */
  pthread_attr_init(&attr);
  /* first inquire on the current scope */
  if (pthread_attr_getscope(&attr, &scope) != 0)
    fprintf(stderr, "Unable to get scheduling scope∖n");
  else
  {
    if (scope == PTHREAD_SCOPE_PROCESS)
      printf("PTHREAD_SCOPE_PROCESS");
    else if (scope == PTHREAD_SCOPE_SYSTEM)
      printf("PTHREAD_SCOPE_SYSTEM");
    else
      fprintf(stderr, "Illegal scope value.∖n");
  }
  /* set the scheduling algorithm to PCS or SCS */
  pthread_attr_setscope(&attr, PTHREAD_SCOPE_SYSTEM);
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
