#ifndef __OUT_PUT_FACTORY    
#define __OUT_PUT_FACTORY

#include "ctType.h"

typedef struct {
   byte * data;
   byte * dataEnd;
   unsigned int  LEN_STR_ESTRUTURA_LINHA;
   unsigned int  LEN_STR_DATA_END;
} ESTRUTURA_LINHA;

typedef struct {
   byte *data;  
   unsigned int  LEN_STR_REF_LINHA_UN;
} ESTRUTURA_COLUNA;

ESTRUTURA_LINHA  __estrutura_linha__;
ESTRUTURA_COLUNA __estrutura_coluna__;

void iniciarRecursos (void);

#endif