#ifndef _CONSTRUCT_REPLACE
#define _CONSTRUCT_REPLACE

typedef void(*asmOutPut)(char*);

void procCol (int vline, int vcol, asmOutPut asmOut);

#endif