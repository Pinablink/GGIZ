#include <stdio.h>
#include <string.h>
#include "../header/header.h"
#include "../header/constructReplace.h"
#include "../header/outPutFactory.h"

unsigned int lPro, cPro;

static char* convertLine (int vline) {
  char* charConvert;

  if (vline >= 100) {
    charConvert = (char*)malloc(3);
    lPro += 2;
  } else if (vline > 9 && vline < 100) {
    charConvert = (char*)malloc(2);
    lPro += 1;
  } else if (vline >= 0 && vline < 10) {
    charConvert = (char*)malloc(sizeof(char));
  }

  return itoa(vline, charConvert, 10);
}

static char* convertCol (int vCol) {
  char* charConvert;

  if (vCol >= 100) {
    charConvert = (char*)malloc(3);
    cPro += 2;
  } else if (vCol > 9 && vCol < 100) {
    charConvert = (char*)malloc(2);
    cPro += 1;
  } else if (vCol >= 0 && vCol < 10) {
    charConvert = (char*)malloc(sizeof(char));
  }

  return itoa(vCol, charConvert, 10);
}


void procCol (int vline, int vcol, asmOutPut f) {
  lPro                     =  0;
  cPro                     =  0;
  unsigned int confLen     =  0;
  unsigned int ctrIndexNew = 0;
  char *strColuna      =  __estrutura_coluna__.data;
  char *strReplaceLine =  convertLine (vline);
  char *strReplaceCol  =  convertCol (vcol); 
  confLen              =  (__estrutura_coluna__.LEN_STR_REF_LINHA_UN + (lPro + cPro));
  char *strOutPut      =  (char*)malloc(confLen);  

  // AREA COM CALCULO ARITMÉTICO DE PONTEIRO PARA MOVIMENTACAO DE VALORES
  for (unsigned int index = 0; index <= confLen; index++) {
     *(strOutPut + (ctrIndexNew++)) = *(strColuna + index);
      
      if (index == 29 || index == 37) {
         if (lPro == 0 && cPro == 0) {

            if (index == 29) {
               *(strOutPut + (ctrIndexNew - 1)) = *(strReplaceLine + 0); 
            } else {
                *(strOutPut + (ctrIndexNew - 1)) = *(strReplaceCol + 0);
            }

         } else if (lPro > 0 && cPro == 0) {
            
           if (index == 29) {
              unsigned int avLenNum = strlen(strReplaceLine);
              if (avLenNum == 2) {
                  *(strOutPut + (--ctrIndexNew)) = *(strReplaceLine + 0);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceLine + 1);
                  ctrIndexNew += 1;
              } else if (avLenNum == 3) {
                  *(strOutPut + (--ctrIndexNew)) = *(strReplaceLine + 0);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceLine + 1);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceLine + 2);
                  ctrIndexNew += 1;
              }
                
            } else {
                *(strOutPut + (ctrIndexNew - 1)) = *(strReplaceCol + 0);
            }

         } else if (lPro == 0 && cPro > 0) {

            if (index == 29) {
               *(strOutPut + (ctrIndexNew - 1)) = *(strReplaceLine + 0); 
            } else {
                unsigned int avLenNum = strlen(strReplaceCol);
              if (avLenNum == 2) {
                  *(strOutPut + (--ctrIndexNew)) = *(strReplaceCol + 0);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceCol + 1);
                  ctrIndexNew += 1;
              } else if (avLenNum == 3) {
                  *(strOutPut + (--ctrIndexNew)) = *(strReplaceCol + 0);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceCol + 1);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceCol + 2);
                  ctrIndexNew += 1;
              }
            } 

         } else if (lPro > 0 && cPro > 0) {
             if (index == 29) {
                unsigned int avLenNum = strlen(strReplaceLine);
              if (avLenNum == 2) {
                  *(strOutPut + (--ctrIndexNew)) = *(strReplaceLine + 0);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceLine + 1);
                  ctrIndexNew += 1;
              } else if (avLenNum == 3) {
                  *(strOutPut + (--ctrIndexNew)) = *(strReplaceLine + 0);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceLine + 1);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceLine + 2);
                  ctrIndexNew += 1;
              } 
            } else {
                unsigned int avLenNum = strlen(strReplaceCol);
              if (avLenNum == 2) {
                  *(strOutPut + (--ctrIndexNew)) = *(strReplaceCol + 0);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceCol + 1);
                  ctrIndexNew += 1;
              } else if (avLenNum == 3) {
                  *(strOutPut + (--ctrIndexNew)) = *(strReplaceCol + 0);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceCol + 1);
                  *(strOutPut + (++ctrIndexNew)) = *(strReplaceCol + 2);
                  ctrIndexNew += 1;
              }
            } 
         }
      }
  
  }
 
  f(strOutPut);
  free(strReplaceLine);
  free(strReplaceCol);
  free(strOutPut);
}



