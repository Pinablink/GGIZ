package recipient

import (
	"bytes"
	"encoding/json"
	"fmt"
	"net/http"
	"os"
	"strconv"
	"strings"
)

//UserReceptor Usuario com Nome e Email para envio de mensagem
type UserReceptor struct {
	Nome  string `json:"nome"`
	Email string `json:"email"`
}

//GroupUserReceptor Possui uma Lista com os Usuários do Sistema GGIZ para envio de mensagem. E a mensagem a ser enviada
type GroupUserReceptor struct {
	ID           int            `json:"id"`
	ListUserDest []UserReceptor `json:"listUserDest"`
	Message      string         `json:"message"`
}

//DisableMessage Estrutura para informar ao banco de dados que a mensagem do Id não deverá ser mais processado
type DisableMessage struct {
	ID     string `json:"id"`
	Status string `json:"status"`
}

func getService() string {
	sservice := strings.TrimSpace(os.Getenv("GGIZ_RECIPIENT_SERVICE"))
	fmt.Println("Path do Servico no Contexto")
	fmt.Println(sservice)
	return sservice
}

func getServiceOffMessage() string {
	sservice := strings.TrimSpace(os.Getenv("GGIZ_RECIPIENT_OFF_MESSAGE"))
	fmt.Println("Path do serviço pare desabilitar mensagem na base de dados")
	fmt.Println(sservice)
	return sservice
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

//PostDisableMessage Realiza o procedimento de cancelamento do envio da mensagem
func PostDisableMessage(refID int) {
	var strID string = strconv.Itoa(refID)

	var disableMessagePlayLoad DisableMessage = DisableMessage{strID, "UNKNOW"}
	mBytes, err := json.Marshal(disableMessagePlayLoad)

	if err != nil {
		fmt.Println("Ocorreu um erro na tentativa de configurar o cancelamento de envio de mensagem")
	} else {
		httpClient := http.Client{}
		req, err := http.NewRequest("POST", getServiceOffMessage(), bytes.NewBuffer(mBytes))

		if err != nil {
			fmt.Println("Ocorreu um erro na preparação do documento de envio da solicitação de cancelamento da mensagem")
		} else {
			req.Header.Set("Content-Type", "application/json")
			_, err := httpClient.Do(req)

			if err != nil {
				fmt.Println("Ocorreu um erro no envio da requisição de cancelamento de envio de mensagem")
			}
		}
	}

}
