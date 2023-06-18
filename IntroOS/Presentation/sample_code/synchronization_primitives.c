#include <pthread.h>
#include <stdio.h>

pthread_mutex_t mutex;
int counter = 0;

void *increment(void *arg) {
  pthread_mutex_lock(&mutex);
  counter++;
  printf("Counter: %d\n", counter);
  pthread_mutex_unlock(&mutex);
  pthread_exit(NULL);
}

int main() {
  pthread_t thread1, thread2;
  pthread_mutex_init(&mutex, NULL);

  pthread_create(&thread1, NULL, increment, NULL);
  pthread_create(&thread2, NULL, increment, NULL);

  pthread_join(thread1, NULL);
  pthread_join(thread2, NULL);

  pthread_mutex_destroy(&mutex);

  return 0;
}
