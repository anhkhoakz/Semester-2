// 2021 Jun 4
// Author: Tran Trung Tin
// Demo passing parameter though system call
#include <stdio.h>

int main(int argc, char **argv)
{
  printf("Number of arguments %i n", argc);
  int i = 0;
  for (i = 0; i < argc; i++)
    printf("Argument %s\t", argv[i]);
  return 0;
}
