#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../header/header.h"
#include "../header/constructReplace.h"
#include "../header/outPutFactory.h"
#include "../header/ctType.h"

void montagem (int linhas, int colunas);

unsigned int main (int argc, char *argv[]) {
    unsigned int linhas  =  atoi(argv[1]);
    unsigned int colunas =  atoi(argv[2]);
   
   iniciarRecursos ();
   system ("cls");
   montagem (linhas, colunas);
    
    return 0;
}

void montagem (int linhas, int colunas) {

    int contadorLinha = 0;
    int contadorColuna = 0;

    printf (AVISO_PROCESSAMENTO, linhas, colunas);
    
    byte *linha       = __estrutura_linha__.data;
    byte *strLinhaFim = __estrutura_linha__.dataEnd;

    for (; contadorLinha < linhas; contadorLinha++) {
       printf ("%s", linha);

            for (; contadorColuna < colunas; contadorColuna++) {
                fflush(stdin);
                procCol (contadorLinha, contadorColuna);
                printf ("%s", strLinhaFim);
            }

        printf ("%s", strLinhaFim);
       contadorColuna = 0;        
    }

    free (linha);
    free (strLinhaFim);
    free (__estrutura_linha__.data);
    free (__estrutura_linha__.dataEnd);
}
