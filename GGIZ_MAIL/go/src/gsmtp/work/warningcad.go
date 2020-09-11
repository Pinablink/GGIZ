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

func (ref *warningcad) Wsend() (bool, error) {
	var smtpMail mail.GGServerMail
	var robotMail mail.GGMail
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
