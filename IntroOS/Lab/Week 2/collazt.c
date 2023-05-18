// 2021 June 2
// Creator: Tran Trung Tin
// Demo using system call fork to create a child process which execute command ls by execlp.

#include <sys/types.h>

#include <stdio.h>

#include <stdlib.h>

#include <unistd.h>

#include <sys/wait.h>

int main(int argc, char **argv)
{
  pid_t pid;

  // Khai báo biến n toàn cục
  int n;
  // Nhận n từ lời gọi
  if (argc != 2)
  {
    printf("Number of arguments wrong");
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
    // Vòng lặp tính và in ra dãy Collatz
    // trong khi mà n > 1
    //  nếu n chẵn thì .....
    //  nếu n lẻ thì ......
    //  in ra n
    printf("Collatz conjecture: %d ", n);
    while (n > 1)
    {
      if (n % 2 == 0)
      {
        n = n / 2;
        printf("%d ", n);
      }
      else if (n % 2 != 0)
      {
        n = 3 * n + 1;
        printf("%d ", n);
      }
    }
  }
  else
  {
    /* parent process */
    // Đơn giản là chỉ đứng chờ con:
    printf("\nKet thuc tien trinh con");
    wait(NULL);
  }
  return 0;
}