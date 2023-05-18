#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    pid_t pid = fork();

    if (pid == -1)
    {
        printf("Failed to create child process.\n");
        exit(1);
    }
    else if (pid == 0)
    {
        printf("Child process with ID %d created.\n", getpid());
        exit(0);
    }
    else
    {
        wait(NULL);
        printf("Parent process with ID %d.\n", getpid());
        system("ps -ef");
    }

    return 0;
}