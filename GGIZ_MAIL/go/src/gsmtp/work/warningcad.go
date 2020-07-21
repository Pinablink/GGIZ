package work

import (
	"fmt"
	"gextractdata/asmmessage"
	"gsmtp/mail"
)

type warningcad struct {
	from              string
	password          string
	contentServerConf []string
}

func (ref *warningcad) wsend() {
	var smtpMail mail.GGServerMail
	var robotMail mail.GGMail
	smtpMail.Serversmtp = ref.contentServerConf[0]
	smtpMail.Pathserver = ref.contentServerConf[1]
	// Chamada de um cache redis
	process, msg := asmmessage.GetMessage()

	if process {
		robotMail.Config(ref.from, ref.password, "pinablink@hotmail.com", msg)
		robotMail.Send(smtpMail)
	} else {
		fmt.Println("Não houve ocorrencia de cadastro para o envio de email")
	}
}
