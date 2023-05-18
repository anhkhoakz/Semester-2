// 2021 June 2
// Author: Abraham Silberschatz  in book Operating System Concepts 8th Edition
// p.170 Demo using how to speed up sum of sequence integer.
#include <pthread.h>

#include <stdio.h>

#include <stdlib.h>

#define MAX_SIZE 100

int a[MAX_SIZE];
int size;

float ave;
int min, max; /* this data is shared by the thread(s) */

void *trungbinh(void *param);
void *lonnhat(void *param);
void *nhonhat(void *param);

void *runner(void *param); /* threads call this function */
// nguyên mẫu các hàm gửi cho thread con

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
        printf("Usage: %s <list of number>\n", argv[0]);
        exit(1);
    }

    // thêm data vào struct mang A;

    size = argc - 1;
    int i;
    for (i = 1; i <= size; i++)
    {
        a[i - 1] = atoi(argv[i]);
    }

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

    printf("Gia tri trung binh: %f\n", ave);
    printf("Gia tri lon nhat: %d\n", max);
    printf("Gia tri nho nhat: %d\n", min);
}
/* The thread will execute in this function */
void *trungbinh(void *param)
{
    int sum = 0;
    int i;
    for (i = 0; i < size; i++)
    {
        sum += a[i];
    }

    ave = (float)sum / size;

    // tìm trung bình
    pthread_exit(0);
}

/* The thread will execute in this function */
void *lonnhat(void *param)
{
    max = a[0];
    int i;
    for (i = 1; i < size; i++)
    {
        if (a[i] > max)
        {
            max = a[i];
        }
    }
    // tìm max
    pthread_exit(0);
}

/* The thread will execute in this function */
void *nhonhat(void *param)
{
    //   int upper = atoi(param);

    min = a[0];
    int i;
    for (i = 1; i < size; i++)
    {
        if (a[i] < min)
        {
            min = a[i];
        }
    }

    // tìm min
    pthread_exit(0);
}