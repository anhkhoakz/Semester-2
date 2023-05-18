// 2021 June 2
// Creator: Tran Trung Tin
// Demo using system call to get ID of this process and its parent.
// Not completed.
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/prct1.h>

int main()
{
    pid_t pid;
    pid = fork();
    if (pid < 0)
        printf("Fork error! No child created\n");
    else if (pid == 0)
    {
        // wait(NULL);
        printf("Hello from Child!\n");
        printf("Child ID is %d!\n", getpid());
        sleep(10);
    }
    else
    {
        wait(NULL);
        printf("Hello from Parent!\n");
        printf("Parent ID is %d!\n", getppid());
    }
    return 0;
}
