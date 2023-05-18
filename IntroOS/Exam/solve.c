#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/ipc.h>
#include <sys/msg.h>
#include <math.h>
#include <semaphore.h>

#define UPPER_LIM 1000 // so ngau nhien lon nhat
int isPrime(int n);    // ham kiem tra so nguyen to
int isSquare(int n);   // ham kiem tra so chinh phuong

// khai bao cau truc de luu tru du lieu
struct data
{
    long mesg_type;
    int n;            // so phan tu cua mang
    int a[UPPER_LIM]; // cac phan tu  cua mang
};

struct message
{
    long mesg_type;
    struct data array;
};

sem_t sem;
pthread_mutex_t mutex;

// thread de kiem tra phan tu nao la nguyen to
void *prime_thread(void *array)
{
    struct data *arr = (struct data *)array;
    for (int i = 0; i < arr->n; i++)
    {
        if (isPrime(arr->a[i]))
        {
            pthread_mutex_lock(&mutex);
            printf("Thread prime saw %d is prime\n", arr->a[i]);
            pthread_mutex_unlock(&mutex);
        }
    }
    return NULL;
}

// thread de kiem tra phan tu nao so chinh phuong
void *square_thread(void *array)
{
    struct data *arr = (struct data *)array;
    for (int i = 0; i < arr->n; i++)
    {
        if (isSquare(arr->a[i]))
        {
            sem_wait(&sem);
            printf("Thread square saw \"%d\" is square\n", arr->a[i]);
            sem_post(&sem);
        }
    }
    return NULL;
}

int main()
{
    // Khởi tạo semaphore và mutex
    sem_init(&sem, 0, 1);
    pthread_mutex_init(&mutex, NULL);

    // Lấy key và id của message queue
    key_t key = ftok(".", 'q');
    int msgid = msgget(key, 0666 | IPC_CREAT);
    if (msgid == -1)
    {
        perror("msgget");
        exit(EXIT_FAILURE);
    }

    // Nhận thông điệp từ message queue
    struct message msg;
    if (msgrcv(msgid, &msg, sizeof(msg.array), 1, 0) == -1)
    {
        perror("msgrcv");
        exit(EXIT_FAILURE);
    }

    // Tạo thread để kiểm tra số nguyên tố
    pthread_t prime_tid;
    if (pthread_create(&prime_tid, NULL, prime_thread, &msg.array))
    {
        perror("pthread_create");
        exit(EXIT_FAILURE);
    }

    // Tạo thread để kiểm tra số chính phương
    pthread_t square_tid;
    if (pthread_create(&square_tid, NULL, square_thread, &msg.array))
    {
        perror("pthread_create");
        exit(EXIT_FAILURE);
    }

    // Chờ các thread kết thúc
    if (pthread_join(prime_tid, NULL))
    {
        perror("pthread_join");
        exit(EXIT_FAILURE);
    }

    if (pthread_join(square_tid, NULL))
    {
        perror("pthread_join");
        exit(EXIT_FAILURE);
    }

    // In kết quả
    int prime_count = 0, square_count = 0;
    for (int i = 0; i < msg.array.n; i++)
    {
        if (isPrime(msg.array.a[i]))
            prime_count++;
        if (isSquare(msg.array.a[i]))
            square_count++;
    }

    printf("Number of primes: %d\n", prime_count);
    printf("Number of squares: %d\n", square_count);

    // Giải phóng semaphore và mutex
    sem_destroy(&sem);
    pthread_mutex_destroy(&mutex);

    return 0;
}

// Ham kiem tra so nguyen to
int isPrime(int n)
{
    if (n <= 1)
        return 0;
    for (int i = 2; i <= sqrt(n); i++)
        if (n % i == 0)
            return 0;
    return 1;
}

// Ham kiem tra so chinh phuong
int isSquare(int n)
{
    if (n < 0)
        return 0;
    int root = sqrt(n);
    return (root * root == n);
}
