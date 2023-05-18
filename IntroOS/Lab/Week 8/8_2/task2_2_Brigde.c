#include <stdio.h>
#include <string.h>
#include <pthread.h>
#include <stdlib.h>
#include <unistd.h>
#include <semaphore.h>

#define MAX_FARMER 10

pthread_t tid[MAX_FARMER];

int north_waiting = 0;
int south_waiting = 0;

pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;

sem_t north_sem; // Declare semaphore for north-bound farmers
sem_t south_sem; // Declare semaphore for south-bound farmers

void north_arrive(int i)
{
  pthread_mutex_lock(&lock);
  printf("\n%d Arriving from the North ...", i);
  if (south_waiting > 0)
  {
    // If there are farmers waiting from the other direction, wait
    north_waiting++;
    pthread_mutex_unlock(&lock);
    // Block until the semaphore allows
    sem_wait(&south_sem);
    pthread_mutex_lock(&lock);
    north_waiting--;
  }
  // Cross the bridge
  printf("\n%d Enter bridge from the North ...", i);
  pthread_mutex_unlock(&lock);
  sleep(rand() % 5 + 3); // random time cost 2 --> 6 s
  pthread_mutex_lock(&lock);
  printf("\n%d Leaving bridge ...", i);
  // Signal to any south-bound farmers that the bridge is now available
  if (south_waiting > 0)
  {
    sem_post(&south_sem);
  }
  else
  {
    // If there are no south-bound farmers waiting, signal to any north-bound farmers that the bridge is now available
    sem_post(&north_sem);
  }
  pthread_mutex_unlock(&lock);
}

void south_arrive(int i)
{
  pthread_mutex_lock(&lock);
  printf("\n%d Arriving from the South ...", i);
  if (north_waiting > 0)
  {
    // If there are farmers waiting from the other direction, wait
    south_waiting++;
    pthread_mutex_unlock(&lock);
    // Block until the semaphore allows
    sem_wait(&north_sem);
    pthread_mutex_lock(&lock);
    south_waiting--;
  }
  // Cross the bridge
  printf("\n%d Enter bridge from the South ...", i);
  pthread_mutex_unlock(&lock);
  sleep(rand() % 5 + 3); // random time cost 2 --> 6 s
  pthread_mutex_lock(&lock);
  printf("\n%d Leaving bridge ...", i);
  // Signal to any north-bound farmers that the bridge is now available
  if (north_waiting > 0)
  {
    sem_post(&north_sem);
  }
  else
  {
    // If there are no north-bound farmers waiting, signal to any south-bound farmers that the bridge is now available
    sem_post(&south_sem);
  }
  pthread_mutex_unlock(&lock);
}

void *farmer(void *param)
{
  int v = *(int *)param;
  free(param);
  // Randomly choose a direction to arrive from
  if (rand() % 2 == 0)
  {
    north_arrive(v);
  }
  else
  {
    south_arrive(v);
  }
  return NULL;
}

int main(void)
{
  time_t t;
  /* Intializes random number generator */
  srand((unsigned)time(&t));
  // Initialize semaphores to 0
  sem_init(&north_sem, 0, 0);
  sem_init(&south_sem, 0, 0);
  for (int i = 0; i < MAX_FARMER; i++)
  {
    int *p = malloc(sizeof i);
    *p = i;
    pthread_create(&tid[i], NULL, farmer, p);
    sleep(rand() % 3); // random time cost 0-4 s
  }
  for (int i = 0; i < MAX_FARMER; i++)
    pthread_join(tid[i], NULL);
  return 0;
}
