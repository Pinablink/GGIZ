#include <stdio.h>
#include "../header/header.h"
#include "../header/constructReplace.h"
#include "../header/outPutFactory.h"

void getCol (int vline, int vcol) {
  char *strColuna      =  __estrutura_coluna__.data;
  char *strReplaceLine =  convertLine (vline);
}


char* convertLine (int vline) {
  char* charConvert;

  if (vline >= 100) {
    charConvert = (char*)calloc(3, sizeof(char));
  } else if (vline > 9 && vline < 100) {
    charConvert = (char*)calloc(2, sizeof(char));
  } else if (vline >= 0 && vline < 10) {
    charConvert = (char*)malloc(sizeof(char));
    __estrutura_coluna__.LEN_STR_RET = 0;
  }

  return itoa(vline, charConvert, 10);
}
