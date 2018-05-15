#include <stdio.h>

int
main(int argc, char **argv) {
  printf("Welcome to the High Low game...\n");
  // Write your implementation here...
  int s = 'y';
  while(s == 'y') {
  int c,low,high,average;
  low = 1;
  high = 100;
  average = (low + high)/2; 
  printf("Think of a number between 1 and 100 and press press <enter>\n");
  getchar();
  while(high >=  low) {    // why >=?
  printf("Is it higher than %d? (y/n)\n",average);
  c = getchar();
  getchar();  
  if(c == 'y') {
   low = average + 1;
   average = (low + high)/2;
   } else if (c == 'n') {
     high = average - 1;
   average = (low + high)/2;
     } else {
	printf("Type y or n\n");
	}
  }

  printf("\n>>>>>> The number is %d\n\n", average + 1); //why average + 1?
  printf("Do you want to continue playing (y/n)?\n");
  s = getchar();
  getchar();
}
return 0;
}
