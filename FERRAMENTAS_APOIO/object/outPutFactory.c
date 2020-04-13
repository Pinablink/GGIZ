#include "../header/outPutFactory.h"

static void configOutputImpl () {
    
}

static void iLinha () {
    __estrutura_linha__  =  *(ESTRUTURA_LINHA*) malloc (sizeof(ESTRUTURA_LINHA));
    __estrutura_linha__.LEN_STR_ESTRUTURA_LINHA = 20;
    __estrutura_linha__.LEN_STR_DATA_END        = 7;
    __estrutura_linha__.data                    = (char*) calloc (__estrutura_linha__.LEN_STR_ESTRUTURA_LINHA ,sizeof(char));
    __estrutura_linha__.dataEnd                 = (char*) calloc (__estrutura_linha__.LEN_STR_DATA_END, sizeof(char));

   *(__estrutura_linha__.data + 0)   =  0x3c;
   *(__estrutura_linha__.data + 1)   =  0x64;
   *(__estrutura_linha__.data + 2)   =  0x69;
   *(__estrutura_linha__.data + 3)   =  0x76;
   *(__estrutura_linha__.data + 4)   =  0x20;
   *(__estrutura_linha__.data + 5)   =  0x63;
   *(__estrutura_linha__.data + 6)   =  0x6c;
   *(__estrutura_linha__.data + 7)   =  0x61;
   *(__estrutura_linha__.data + 8)   =  0x73;
   *(__estrutura_linha__.data + 9)   =  0x73;
   *(__estrutura_linha__.data + 10)  =  0x3d;
   *(__estrutura_linha__.data + 11)  =  0x22;
   *(__estrutura_linha__.data + 12)  =  0x6c;
   *(__estrutura_linha__.data + 13)  =  0x69;
   *(__estrutura_linha__.data + 14)  =  0x6e;
   *(__estrutura_linha__.data + 15)  =  0x68;
   *(__estrutura_linha__.data + 16)  =  0x61;
   *(__estrutura_linha__.data + 17)  =  0x22;
   *(__estrutura_linha__.data + 18)  =  0x3e;
   *(__estrutura_linha__.data + 19)  =  0x0A;

   *(__estrutura_linha__.dataEnd + 0) =  0x3c;
   *(__estrutura_linha__.dataEnd + 1) =  0x2f;
   *(__estrutura_linha__.dataEnd + 2) =  0x64;
   *(__estrutura_linha__.dataEnd + 3) =  0x69;
   *(__estrutura_linha__.dataEnd + 4) =  0x76;
   *(__estrutura_linha__.dataEnd + 5) =  0x3e;
   *(__estrutura_linha__.dataEnd + 6) =  0x0A;  
}

static void iColuna () {
    __estrutura_coluna__                                 =   *(ESTRUTURA_COLUNA*) malloc (sizeof (ESTRUTURA_COLUNA));
    __estrutura_coluna__.LEN_STR_REF_LINHA_UN            =   51;
    __estrutura_coluna__.LEN_STR_REF_LINHA_DEC           =   53; 
    __estrutura_coluna__.CHAR_POS_REP_ESTRUTURA_LINHA    =   29;
    __estrutura_coluna__.CHAR_POS_REP_ESTRUTURA_COLUNA   =   37;
    __estrutura_coluna__.LEN_STR_RET                     =   0;   
    __estrutura_coluna__.data                            =   (char*) calloc (__estrutura_coluna__.LEN_STR_REF_LINHA_UN, sizeof(char));
    __estrutura_coluna__.refConfigOutPut                 =   &configOutputImpl;

    *(__estrutura_coluna__.data + 0)                     = 0x3c;
    *(__estrutura_coluna__.data + 1)                     = 0x64;
    *(__estrutura_coluna__.data + 2)                     = 0x69;
    *(__estrutura_coluna__.data + 3)                     = 0x76;
    *(__estrutura_coluna__.data + 4)                     = 0x20;
    *(__estrutura_coluna__.data + 5)                     = 0x63;
    *(__estrutura_coluna__.data + 6)                     = 0x6c;
    *(__estrutura_coluna__.data + 7)                     = 0x61;
    *(__estrutura_coluna__.data + 8)                     = 0x73;
    *(__estrutura_coluna__.data + 9)                     = 0x73;
    *(__estrutura_coluna__.data + 10)                    = 0x3d;
    *(__estrutura_coluna__.data + 11)                    = 0x22;
    *(__estrutura_coluna__.data + 12)                    = 0x63;
    *(__estrutura_coluna__.data + 13)                    = 0x6f;
    *(__estrutura_coluna__.data + 14)                    = 0x6c;
    *(__estrutura_coluna__.data + 15)                    = 0x75;
    *(__estrutura_coluna__.data + 16)                    = 0x6e;
    *(__estrutura_coluna__.data + 17)                    = 0x61;
    *(__estrutura_coluna__.data + 18)                    = 0x22;
    *(__estrutura_coluna__.data + 19)                    = 0x20;
    *(__estrutura_coluna__.data + 20)                    = 0x69;
    *(__estrutura_coluna__.data + 21)                    = 0x64; 
    *(__estrutura_coluna__.data + 22)                    = 0x3d;
    *(__estrutura_coluna__.data + 23)                    = 0x22; 
    *(__estrutura_coluna__.data + 24)                    = 0x6c;
    *(__estrutura_coluna__.data + 25)                    = 0x69;
    *(__estrutura_coluna__.data + 26)                    = 0x6e;
    *(__estrutura_coluna__.data + 27)                    = 0x68;
    *(__estrutura_coluna__.data + 28)                    = 0x61;
    *(__estrutura_coluna__.data + 29)                    = 0x24;
    *(__estrutura_coluna__.data + 30)                    = 0x5f;
    *(__estrutura_coluna__.data + 31)                    = 0x63;
    *(__estrutura_coluna__.data + 32)                    = 0x6f;
    *(__estrutura_coluna__.data + 33)                    = 0x6c;
    *(__estrutura_coluna__.data + 34)                    = 0x75;
    *(__estrutura_coluna__.data + 35)                    = 0x6e;
    *(__estrutura_coluna__.data + 36)                    = 0x61;
    *(__estrutura_coluna__.data + 37)                    = 0x23;
    *(__estrutura_coluna__.data + 38)                    = 0x22;
    *(__estrutura_coluna__.data + 39)                    = 0x20;
    *(__estrutura_coluna__.data + 40)                    = 0x76;
    *(__estrutura_coluna__.data + 41)                    = 0x61;
    *(__estrutura_coluna__.data + 42)                    = 0x6c;
    *(__estrutura_coluna__.data + 43)                    = 0x75;
    *(__estrutura_coluna__.data + 44)                    = 0x65;
    *(__estrutura_coluna__.data + 45)                    = 0x3d;
    *(__estrutura_coluna__.data + 46)                    = 0x22;
    *(__estrutura_coluna__.data + 47)                    = 0x30; 
    *(__estrutura_coluna__.data + 48)                    = 0x22;
    *(__estrutura_coluna__.data + 49)                    = 0x2f;
    *(__estrutura_coluna__.data + 50)                    = 0x3e;      
}

void  iniciarRecursos (void) {
    iLinha();
    iColuna ();
}