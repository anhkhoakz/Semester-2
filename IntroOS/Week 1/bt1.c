// 2023 Mar 6
// Author: Tran Trung Tin
// Viết chương trình sau cho khi truyền đối số n vào thì xuất ra tổng S = 1 + 2 + .... + n
// a. Báo lỗi nếu lời gọi có đối số không phải là một số nguyên dương.
// b. Báo lỗi nếu có nhiều hơn 2 đối số (là main.out và n).

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char **argv)
{
  int n;
  if (argc != 2)
  {
    printf("Number of arguments wrong (case b.)");
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
    int i, sum = 0;
    for (i = 0; i <= n; i++)
    {
      sum += i;
    }
    printf("\nSum = %d", sum);
  }

  return 0;
}
