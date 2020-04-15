#include <stdio.h>
#include "../header/header.h"
#include "../header/constructReplace.h"
#include "../header/outPutFactory.h"

unsigned int lPro, cPro;

char* convertLine (int vline) {
  char* charConvert;

  if (vline >= 100) {
    charConvert = (char*)calloc(3, sizeof(char));
    lPro += 2;
  } else if (vline > 9 && vline < 100) {
    charConvert = (char*)calloc(2, sizeof(char));
    lPro += 1;
  } else if (vline >= 0 && vline < 10) {
    charConvert = (char*)malloc(sizeof(char));
  }

  return itoa(vline, charConvert, 10);
}

char* convertCol (int vCol) {
  char* charConvert;

  if (vCol >= 100) {
    charConvert = (char*)calloc(3, sizeof(char));
    cPro += 2;
  } else if (vCol > 9 && vCol < 100) {
    charConvert = (char*)calloc(2, sizeof(char));
    cPro += 1;
  } else if (vCol >= 0 && vCol < 10) {
    charConvert = (char*)malloc(sizeof(char));
  }

  return itoa(vCol, charConvert, 10);
}

void procCol (int vline, int vcol, asmOutPut f) {
  // ATENÇAO - PONTO EM ATIVIDADE
  
  /*lPro                 =  0;
  cPro                 =  0;
  unsigned int confLen =  0;
  char *strColuna      =  __estrutura_coluna__.data;
  char *strReplaceLine =  convertLine (vline);
  char *strReplaceCol  =  convertCol (vcol); 
  confLen              =  (__estrutura_coluna__.LEN_STR_REF_LINHA_UN + (lPro + cPro));
  char *strOutPut      =  (char*)calloc(confLen, sizeof(char));  

  for (unsigned int index = 0; ) {
     (strOutPut)
  }
  */
  //f(testeP);
}



