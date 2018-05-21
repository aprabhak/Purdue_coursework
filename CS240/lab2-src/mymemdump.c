
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

void mymemdump(FILE * fd, char * p , int len) {
	// Add your code here.
	// You may see p as an array.
	// p[0] will return the element 0 
	// p[1] will return the element 1 and so on

	/* fprintf(fd, "0x%016lX: ", (unsigned long) p);
	   int c = p[0]&0xFF;

	// Print first byte as hexadecimal
	fprintf(fd, "%02X ", c); 

	// Print first byte as character
	fprintf(fd, "%c", (c>=32)?c:'.');
	fprintf(fd,"\n"); */

	/*  int c = 0;
	    fprintf(fd, "0x%016lX: ",(unsigned long)p);
	    for (int i = 0; i <= len; i++) {
	    if (i%16==0 && (i != 0)) {
	    fprintf(fd," ");
	    for (int j = i-16; j < i; j++) {
	    char d = p[j]&0xFF;
	    fprintf(fd, "%c", (d >= 32 && d <= 127)?d:'.');
	    }
	    if (i != len) {
	    fprintf(fd,"\n");
	    fprintf(fd, "0x%016lX: ",(unsigned long)p + i);
	    }
	    }
	    if (i != len) {
	    c = p[i]&0xFF;
	    fprintf(fd, "%02X", c);
	    fprintf(fd," ");
	    }
	    } 

var5


	    if (len / 16 != 0 ) {
	    for (int i = 0; i < len % 16; i++) {
	    c = p[i]&0xFF;
	    fprintf(fd, " ");
	    if (
	    }
	    } 
	    fprintf(fd,"\n");*/
	int c;
	int buffer[17];
	int buffcount = 0;
	for (int i = 0; i < len; i++) {
		if (i % 16 == 0 && i != 0) {
			fprintf(fd," ");
			for (int j = 0; j < buffcount; j++) {
				fprintf(fd, "%c", (buffer[j] >= 32 && buffer[j] <= 127)?buffer[j]:'.');
			}
			buffcount = 0;
			fprintf(fd,"\n");
		}
		if (i % 16 == 0) {
			fprintf(fd, "0x%016lX: ",(unsigned long)p + i);
		}

		c = p[i]&0xFF;
		fprintf(fd, "%02X", c);
		fprintf(fd," ");
		buffer[buffcount] = c;
		buffcount++;

	}
	fprintf(fd," ");
	for (int m = buffcount; m < 16; m++) {
	     fprintf(fd,"   ");
	     }
	for (int k = 0; k < buffcount; k++) {
		fprintf(fd, "%c", (buffer[k] >= 32 && buffer[k] <= 127)?buffer[k]:'.');
	}
	fprintf(fd,"\n");

}

