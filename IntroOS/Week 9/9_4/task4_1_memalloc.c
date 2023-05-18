// 2021 June 20
// Author: Tran Trung Tin
// Demo of Continuous Allocation in Memory

#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>

// Hole structure representing a free memory region
struct hole {
  int iPID;  //-1 unused
  int iBase;
  int iSize;
  char sName[20];
};

struct hole M[100];    // Memory array
int iHoleCount = 0;    // Number of holes
int iPIDcount = 1000;  // Next PID to assign to a process

// Allocate memory for a new process
void* allocate_memory() {
  int iSizeNew;
  printf("\nSize of process: ");
  scanf("%d", &iSizeNew);

  // Loop through the used holes to find a hole that can fit the new process
  for (int i = 0; i < iHoleCount; i++) {
    if (M[i].iPID == -1) {
      if (M[i].iSize < iSizeNew) {
        continue;  // Hole too small, look for another hole
      }
      if (M[i].iSize == iSizeNew) {
        // Allocate to replace this hole, no new hole left
        M[i].iPID = iPIDcount++;
        printf("\nNew process allocated PID = %d from %d to %d\n", M[i].iPID,
               M[i].iBase, M[i].iBase + M[i].iSize - 1);
        return 0;
      } else if (M[i].iSize > iSizeNew) {
        // Allocate to this hole, but leave a new smaller hole
        iHoleCount++;
        for (int j = iHoleCount; j > i + 1; j--) {
          M[j] = M[j - 1];  // Shift right all holes to make space for new hole
        }
        M[i + 1].iPID = -1;
        M[i + 1].iSize = M[i].iSize - iSizeNew;
        M[i + 1].iBase = M[i].iBase + iSizeNew;
        M[i].iPID = iPIDcount++;
        M[i].iSize = iSizeNew;
        printf("\nNew process allocated PID = %d from %d to %d", M[i].iPID,
               M[i].iBase, M[i].iBase + M[i].iSize - 1);
        printf("\nNew hole left over from %d to %d\n", M[i + 1].iBase,
               M[i + 1].iBase + M[i + 1].iSize - 1);
        return 0;
      }
    }
  }
  printf(
      "\nFailure to allocate memory.\n");  // No hole available for allocation
  return 0;
}

// Terminate a process and free its allocated memory
void* terminate_process() {
  int iTerminated;
  printf("\nWhich PID terminate? ");
  scanf("%d", &iTerminated);
  for (int i = 0; i < iHoleCount; i++) {
    if (iTerminated == M[i].iPID) {
      M[i].iPID = -1;
      printf("\nProcess %d has been removed. Memory from %d to %d is free.",
             M[i].iPID, M[i].iBase, M[i].iBase + M[i].iSize - 1);
      return 0;
    }
  }
  printf("Process %d cannot be found.", iTerminated);
  return 0;
}

// Compact memory by moving all used holes to the beginning and freeing up all
// unused holes at the end
void* compact_memory() {
  int iReAlloc = 0;
  int iHoleCollect = 0;
  int iSizeCollect = 0;

  // Loop through all holes to collect unused ones and compact used ones
  for (int i = 0; i < iHoleCount; i++) {
    if (M[i].iPID == -1) {
      // If a hole is found, add its size to iReAlloc and collect it
      iReAlloc -= M[i].iSize;
      iHoleCollect++;
      iSizeCollect += M[i].iSize;
    } else {
      // If a process is found, move it to the beginning of M and adjust its
      // base accordingly
      M[i - iHoleCollect].iPID = M[i].iPID;
      M[i - iHoleCollect].iBase = M[i].iBase + iReAlloc;
      M[i - iHoleCollect].iSize = M[i].iSize;
    }
  }

  // Adjust the hole count and add a new hole at the end
  iHoleCount -= iHoleCollect;
  M[iHoleCount].iPID = -1;
  M[iHoleCount].iBase = M[iHoleCount - 1].iBase + M[iHoleCount - 1].iSize;
  M[iHoleCount].iSize = iSizeCollect;

  printf("\nMemory compacted. %d bytes reclaimed.\n", iSizeCollect);
  return 0;
}

// Print the status of memory (used and unused holes)
void* print_memory_status() {
  printf("\nStatic of memory \n");
  for (int i = 0; i < iHoleCount; i++) {
    if (M[i].iPID == -1) {
      printf("Address [%d : %d]: Unused\n", M[i].iBase,
             M[i].iBase + M[i].iSize - 1);
    } else {
      printf("Address [%d : %d]: ProcessID %d\n", M[i].iBase,
             M[i].iBase + M[i].iSize - 1, M[i].iPID);
    }
  }
  return 0;
}

int main(int argc, char* argv[]) {
  if (argc < 2) {
    printf("Usage: %s <initial_size>\n", argv[0]);
    return 1;
  }

  // Initialize the memory with a single hole of the given size
  M[iHoleCount].iSize = atoi(argv[1]);
  M[iHoleCount].iPID = -1;
  M[iHoleCount].iBase = 0;
  iHoleCount = 1;

  while (true) {
    int iOption;
    printf(
        "\nChon option: 1-Cap phat 2-Thu hoi 3-Gom cum 4-Thong ke 5-Thoat\n");
    scanf("%d", &iOption);

    switch (iOption) {
      case 1:
        allocate_memory();
        break;
      case 2:
        terminate_process();
        break;
      case 3:
        compact_memory();
        break;
      case 4:
        print_memory_status();
        break;
      case 5:
        return 0;
      default:
        printf("\nVui long chon 1 - 5.\n");
        break;
    }
  }
  }