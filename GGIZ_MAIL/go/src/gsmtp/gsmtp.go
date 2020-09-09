package main

import (
	"fmt"
	"gsmtp/engine"
	"gsmtp/work"
)

func main() {
	order, err := engine.GetOrder()

	if err != nil {
		fmt.Println("GSMTP: Erro na obtencao da ordem de trabalho")
	} else {

		fmt.Println("Ordem do sistema")
		fmt.Println(order)
		fmt.Println("Configuracao para montagem de email")

		serverBinary, binaryData, err := engine.GetDataConfMail()

		fmt.Println("Inicializando o processo de configuracao e obtenção de dados para envio")

		if err != nil {
			fmt.Println("GSMTP: Erro na obtencao dos dados para configuração do servidor de smtp")
		} else {
			work.Loadtasks(binaryData, serverBinary)
			work.Exectask(order)
		}
	}
}
