package grpcst

import (
	"gsmtp/work"
        "strings"
)

var (
	//
	RefMapInterface map[string]work.Worksmtpmail
)

//
type RemoteInterface struct {
	Processado bool
	Message    string
}

//
type Listener int

//GetWorkTask
func (h *Listener) GetWorkTaskMail(orderParam string, target *RemoteInterface) error {

     	_, err := RefMapInterface[strings.TrimSpace(orderParam)].Wsend()

	if err != nil {
		*target = RemoteInterface{false, "Solicitacao de envio de email nao atendido"}
	} else {
		*target = RemoteInterface{true, "Solicitacao de envio de email atendido"}
	}

	return nil
}
