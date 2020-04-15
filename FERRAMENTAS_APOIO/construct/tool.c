#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "../header/header.h"
#include "../header/constructReplace.h"
#include "../header/outPutFactory.h"

FILE *OUTPUT;

void montagem (int linhas, int colunas);
void escrever (char * conteudo);

unsigned int main (void) {
      int linhas =  0;
      int colunas = 0;

      iniciarRecursos ();
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
    
    char *linha       = __estrutura_linha__.data;
    char *strLinhaFim = __estrutura_linha__.dataEnd;

    for (; contadorLinha < linhas; contadorLinha++) {
       
       //ENVIAR PARA OUTPUT
       printf ("%s", linha);

            for (; contadorColuna < colunas; contadorColuna++) {
                
                //char *strColuna = getCol (contadorLinha, contadorColuna);
                //ENVIAR PARA OUTPUT AQUI
                procCol (contadorLinha, contadorColuna, &escrever);
                //free (strColuna);
            }

        //ENVIAR PARA OUTPUT
        printf ("%s", strLinhaFim);
       contadorColuna = 0; 
       
    }

    free (linha);
    free (strLinhaFim);
}

void escrever (char * conteudo) {
    printf ("/%s\n", conteudo);
}