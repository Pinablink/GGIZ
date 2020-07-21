package main

import (
	"fmt"
	"gsmtp/engine"
	"gsmtp/work"
)

func main() {

	fmt.Println("Teste")
	order, err := engine.GetOrder()

	if err != nil {
		fmt.Println("GSMTP: Erro na obtencao da ordem de trabalho")
	} else {

		serverBinary, binaryData, err := engine.GetDataConfMail()

		if err != nil {
			fmt.Println("GSMTP: Erro na obtencao dos dados para configuração do servidor de smtp")
		} else {
			work.Loadtasks(binaryData, serverBinary)
			work.Exectask(order)
		}
	}
}
