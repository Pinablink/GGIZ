package mail

import "fmt"

func showRemetMessage(test bool) {
	if test == true {
		fmt.Println("Conteúdo informado para Remetente foi Configurado com Sucesso")
	} else {
		fmt.Println("Conteúdo informado para Remetente não foi Configurado. Revisar Dados")
	}
}

func showDestMessage(test bool) {
	if test == true {
		fmt.Println("Conteúdo informado para Destinatario foi Configurado com Sucesso")
	} else {
		fmt.Println("Conteúdo informado para Destinatario não foi Configurado. Revisar Dados")
	}
}

func showValidMessage(test bool) {
	if test == true {
		fmt.Println("Conteúdo informado para Mensagem esta correto")
	} else {
		fmt.Println("Conteúdo informado para Mensagem não esta correto")
	}
}
