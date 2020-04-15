#ifndef _OUT_PUT_FACTORY    
#define __OUT_PUT_FACTORY

typedef struct {
   char * data;
   char * dataEnd;
   unsigned int  LEN_STR_ESTRUTURA_LINHA;
   unsigned int  LEN_STR_DATA_END;
} ESTRUTURA_LINHA;

typedef struct {
   char * data;  
   unsigned int  LEN_STR_REF_LINHA_UN;
   unsigned int  CHAR_POS_REP_ESTRUTURA_LINHA;
   unsigned int  CHAR_POS_REP_ESTRUTURA_COLUNA; 
} ESTRUTURA_COLUNA;

ESTRUTURA_LINHA  __estrutura_linha__;
ESTRUTURA_COLUNA __estrutura_coluna__;

void iniciarRecursos (void);

#endif