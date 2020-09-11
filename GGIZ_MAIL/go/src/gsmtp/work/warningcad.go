package work

import (
	"fmt"
	"gextractdata/asmmessage"
	"gsmtp/engine"
	"gsmtp/mail"
	"log"
)

type warningcad struct {
	from              string
	password          string
	contentServerConf []string
}

func uBroadcastOrder() {
	err := engine.AjustBroadcastOrder()

	if err != nil {
		log.Fatal(err)
		fmt.Println("Alteração de Ordem falhou")
	} else {
		fmt.Println("Ordem alterada com sucesso")
	}

}

func (ref *warningcad) Wsend() (bool, error) {
	fmt.Println("Warning Cad Order")
	var smtpMail mail.GGServerMail
	var robotMail mail.GGMail

	uBroadcastOrder()
	smtpMail.Serversmtp = ref.contentServerConf[0]
	smtpMail.Pathserver = ref.contentServerConf[1]
	// Chamada de um cache redis
	process, msg := asmmessage.GetMessage()

	if process {
		robotMail.Config(ref.from, ref.password, "pinablink@hotmail.com", msg)
		ok, err := robotMail.Send(smtpMail)

		if err != nil {
			fmt.Println(err)
			return ok, err
		}

	}

	return true, nil
}
