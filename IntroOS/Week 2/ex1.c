// 2021 June 2
// Creator: Tran Trung Tin
// Exercise
#include <sys/types.h>

#include <stdio.h>

#include <stdlib.h>

#include <unistd.h>

#include <sys/wait.h>

int main(int argc, char **argv)
{
  pid_t pid;

  // khai báo biến toàn cục n
  int n;
  // lấy giá trị n vào từ lời gọi
  if (argc != 2)
  {
    printf("Number of arguments wrong(case b.)");
    return -1;
  }
  else
  {
    n = atol(argv[1]);
  }
  /* fork a child process */
  pid = fork();
  if (pid < 0)
  {
    /* error occurred */
    fprintf(stderr, "Fork Failed");
    return 1;
  }
  else if (pid == 0)
  {
    /* child process */
    // vòng lặp tính tổng S
    int s = 0;
    int i;
    for (i = 1; i <= n; i++)
    {
      s += i;
    }
    // in ra S
    printf("Tong S: %d", s);
  }
  else
  {
    /* parent process */
    // tính ước số
    int s;
    int i;
    for (i = 1; i <= n; i++)
    {
      if (n % i == 0)
      {
        s += i;
      }
    }
    // in ra
    printf("Tong uoc so: %d", s);
    wait(NULL);
  }
  return 0;
}