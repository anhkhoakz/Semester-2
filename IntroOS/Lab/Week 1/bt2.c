#include <stdio.h>
#include <stdlib.h>

int isPrime(int n)
{
    if (n < 2)
    {
        return 0;
    }
    int i;
    for (i = 2; i * i <= n; i++)
    {
        if (n % i == 0)
        {
            return 0;
        }
    }
    return 1;
}

int main(int argc, char **argv)
{
    int n;
    if (argc != 2)
    {
        printf("Number of arguments wrong(case b.)");
        return -1;
    }
    else
    {
        n = atoi(argv[1]);
        if (n <= 0)
        {
            printf("Day khong phai la so nguyen duong\n");
            return 0;
        }
        int i;
        printf("Cac uoc so cua %d la:", n);
        for (i = 1; i <= n; i++)
        {
            if (n % i == 0)
            {
                printf(" %d,", i);
            }
        }
        printf("\n");
        printf("Cac thua so nguyen to: ");
        for (i = 2; i <= n; i++)
        {
            if (n % i == 0 && isPrime(i))
            {
                printf(" %d +", i);
                n /= i;
                i--;
            }
        }
        printf("\n");
    }
    return 0;
}
