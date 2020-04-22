#include <stdio.h>
#include <string.h>
#include "../header/header.h"
#include "../header/constructReplace.h"
#include "../header/outPutFactory.h"

unsigned int lPro, cPro;


static byte * convertLine (int vline) {
  byte * charConvert;

  if (vline >= 100) {
    charConvert = (byte *)malloc(3);
    lPro += 2;
  } else if (vline > 9 && vline < 100) {
    charConvert = (byte *)malloc(2);
    lPro += 1;
  } else if (vline >= 0 && vline < 10) {
    charConvert = (byte *)malloc(sizeof(byte));
  }

  return itoa(vline, charConvert, 10);
}

static byte * convertCol (int vCol) {
  byte * charConvert;

  if (vCol >= 100) {
    charConvert = (byte *)malloc(3);
    cPro += 2;
  } else if (vCol > 9 && vCol < 100) {
    charConvert = (byte *)malloc(2);
    cPro += 1;
  } else if (vCol >= 0 && vCol < 10) {
    charConvert = (byte *)malloc(sizeof(byte));
  }

  return itoa(vCol, charConvert, 10);
}

static void rL (byte * ct) {
    
    for (unsigned int index = 0; index < strlen(ct); index++) {
        byte rb = *(ct + index);
        printf ("%c", rb);
    }   
}

void procCol (int vline, int vcol) {
  lPro                     =  0;
  cPro                     =  0;
  unsigned int confLen     =  0;
  unsigned int ctIndex     =  0;
  byte *strColuna      =  __estrutura_coluna__.data;
  byte *strReplaceLine =  convertLine (vline);
  byte *strReplaceCol  =  convertCol (vcol); 
  confLen              =  (__estrutura_coluna__.LEN_STR_REF_LINHA_UN + (lPro + cPro));
  
  unsigned int count =  (strlen(strColuna) - 1);

  for (unsigned int index = 0; index < count; index++) {
      byte b = *(strColuna + index);
      
      if (b == 0x23 || b == 0x24) {
      
        if (b == 0x23) {
          rL (strReplaceLine);
        } else {
          rL (strReplaceCol);
        }

      } else {
          printf ("%c", b);
      }

      
  }
  
  free (strReplaceLine);
  free (strReplaceCol);
}



