#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../header/header.h"
#include "../header/constructReplace.h"


FILE *OUTPUT;

void montagem (int linhas, int colunas);

unsigned int main (void) {
      int linhas =  0;
      int colunas = 0;

     system ("cls");
     printf ("%s", INIT_WELCOME); 
     system ("PAUSE");
     system ("cls");
     printf ("%s\n", QT_LINHAS);
     scanf ("%d", &linhas);
     printf ("%s\n", QT_COLUNAS);   
     scanf ("%d", &colunas);
     fflush (stdin);
     montagem (linhas, colunas);   
    
    return 0;
}

void montagem (int linhas, int colunas) {

    int contadorLinha = 0;
    int contadorColuna = 0;
    
    system ("cls");
    printf (AVISO_PROCESSAMENTO, linhas, colunas);
    system ("PAUSE");

    for (; contadorLinha <= linhas; contadorLinha++) {
       
       char *linha = (char*)calloc (LEN_STR_ESTRUTURA_LINHA, sizeof(char)); 
       linha = ESTRUTURA_LINHA;
       
       printf ("%s\n", linha);

            for (; contadorColuna < colunas; contadorColuna++) {
                char *strColuna = getCol (contadorLinha, contadorColuna);
                //ENVIAR PARA OUTPUT AQUI
                printf ("%s\n", strColuna);
                free (strColuna);
            }

       //contadorColuna = 0; 
       free (linha);

    }

}