package recipient

import (
	"encoding/json"
	"fmt"
	"net/http"
	"os"
	"strings"
)

//UserReceptor Usuario com Nome e Email para envio de mensagem
type UserReceptor struct {
	Nome  string `json:"nome"`
	Email string `json:"email"`
}

//GroupUserReceptor Possui uma Lista com os Usuários do Sistema GGIZ para envio de mensagem. E a mensagem a ser enviada
type GroupUserReceptor struct {
	ListUserDest []UserReceptor `json:"listUserDest"`
	Message      string         `json:"message"`
}

//GetService Teste
func getService() string {
	return strings.TrimSpace(os.Getenv("GGIZ_RECIPIENT_SERVICE"))
}

//GetListRecipient Obtem a Lista para o envio de mensagem de email
func GetListRecipient() GroupUserReceptor {
	resp, err := http.Get(getService())
	var gReceptors GroupUserReceptor

	if err != nil {
		fmt.Println("Lista de Destinatarios para envio de mensagem, não encontrado")
	} else {
		defer resp.Body.Close()

		jsonDecoder := json.NewDecoder(resp.Body)
		err = jsonDecoder.Decode(&gReceptors)

		if err != nil {
			fmt.Println("Ocorreu na Decodificação do Objeto retornado pelo Serviço de Recipients")
		}
	}

	return gReceptors
}
