// 2021 June 2
// Author: Abraham Silberschatz  in book Operating System Concepts 8th Edition p.170
// Demo using how to speed up sum of sequence integer.
#include <pthread.h>

#include <stdio.h>

#include <stdlib.h>

int min, max; /* this data is shared by the thread(s) */
float ave;
int a[100]; /* the shared array */
int size;

void *runner(void *param); /* threads call this function */
// nguyên mẫu các hàm gửi cho thread con

int main(int argc, char *argv[])
{

  // thêm data vào struct mang A;

  pthread_t tid[3];    /* the thread identifier */
  pthread_attr_t attr; /* set of thread attributes */
  /* set the default attributes of the thread */
  pthread_attr_init(&attr);
  /* create the thread */
  pthread_create(&tid[0], &attr, trungbinh, NULL);
  pthread_create(&tid[1], &attr, lonnhat, NULL);
  pthread_create(&tid[2], &attr, nhonhat, NULL);
  /* wait for the thread to exit */
  pthread_join(tid[0], NULL);
  pthread_join(tid[1], NULL);
  pthread_join(tid[2], NULL);
}
/* The thread will execute in this function */
void *trungbinh(void *param)
{

  // tìm trung bình
  pthread_exit(0);
}

/* The thread will execute in this function */
void *lonnhat(void *param)
{
  // tìm max
  pthread_exit(0);
}

/* The thread will execute in this function */
void *nhonhat(void *param)
{
  int upper = atoi(param);
  // tìm min
  pthread_exit(0);
}
