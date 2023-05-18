// 2021 Jun 15
// Author: Tran Trung Tin, based on [1] Chapter 5 Programming Assignment.
// FCFS running an array already read from file by driver.c

#include "task.h"

extern int process;

// Comparison function for qsort
int cmp(const void *a, const void *b)
{
  const Task *task_a = (Task *)a;
  const Task *task_b = (Task *)b;
  return task_a->arrival - task_b->arrival;
}

void *FCFS(void *param)
{
  int t_wait = 0, t_taround = 0;
  int time = 0;

  // SORTING ARRIVAL TIME USING QUICK SORT
  qsort(task, process, sizeof(Task), cmp);

  // Sắp xếp mảng cấu trúc task với key là thời điểm đến
  for (int i = 0; i < process; i++)
  {
    run(&task[i], time, task[i].burst); // Run from time to time+burst
    time += task[i].burst;              // moving to next P
    t_wait += time - task[i].burst - task[i].arrival;
    t_taround += time - task[i].arrival;
  }
  printf("\nFCFS Time wait ave = %.2f", t_wait * 1.0 / process);
  printf("\nFCFS Time turn around ave = %.2f", t_taround * 1.0 / process);
  pthread_exit(0);
}