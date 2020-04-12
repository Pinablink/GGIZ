#include <stdio.h>
#include "../header/header.h"
#include "../header/constructReplace.h"

static typdef {
 char *value;
 int  vlRefLine; // Quantidade de numeros da Linha
 int  vlRefCol;  // Quantidade de numeros da Coluna
 int  lenRetCol;
 int  iPos;
} COL_CTR;

static COL_CTR convert (int vline, int vcol);
static void  convertCol (COL_CTR*);
static int   LEN_RET_COL;
static int   iPos;

char* getCol (int vline, int vcol) {
  //char *strLine = convert (vline);
  //char *strCol  = convert (vcol);
  char *ref     = ESTRUTURA_COLUNA;
  char *ret     = (char*)calloc(50, sizeof(char));
  int  index    = 0;
  int  len      = LEN_STR_ESTRUTURA_COLUNA_UN;
  
    for (; index <= len; index++) {
        *(ret + index) = *(ref + index);
    }  

  //Limpeza
  //free (strLine);
  //free (strCol);
  free (ref);
  
  return ret;
}

static COL_CTR convertCol (int vline, int vcol) {
    
    COL_CTR retColCTR = *(COL_CTR*)malloc(sizeof(COL_CTR));

    if (vline > 9) {
        //LEN_STR_ESTRUTURA_LINHA_DEC

    } else if (vline < 9) {
        //LEN_STR_ESTRUTURA_LINHA_UN

    }

    return retColCTR;
}

static void wCol (COL_CTR*) {

}

/*char* convertLine (int vline) {
  char* charConvert;

  if (vline >= 100) {
    iPos = 3;
    charConvert = (char*)calloc(3, sizeof(char));
    LEN_RET_COL = LEN_STR_ESTRUTURA_COLUNA_UN;
  } else if (vline > 9 && vline < 100) {
    iPos = 2;  
    charConvert = (char*)calloc(2, sizeof(char));
    LEN_RET_COL = LEN_STR_ESTRUTURA_COLUNA_DEC;
  } else if (vline >= 0 && vline < 10) {
    iPos = 1; 
    charConvert = (char*)malloc(sizeof(char));
    LEN_RET_COL = LEN_STR_ESTRUTURA_COLUNA_CENT;
  }

  return itoa(vline, charConvert, 10);
}*/
