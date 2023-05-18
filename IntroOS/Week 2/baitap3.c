#include <stdio.h>

int main()
{
  len = 4 int a[len] = {7, 6, 2, 9};
  int i, j;
  for (i = 0; i < len; i++)
  {
    for (j = len - 1; j > i; j--)
    {
      if a
        [j] < a[j - 1]
        {
          temp = a[j];
          a[j] = a[j - 1];
          a[j - 1] = temp;
        }
    }
  }
  for (i = 0; i < 4; i++)
  {
    printf("%d ", a[i]);
  }
}