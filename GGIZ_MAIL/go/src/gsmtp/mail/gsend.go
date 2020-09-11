package mail

import (
	"net/smtp"
	"strings"
)

// Send Envia email utilizando os parâmetros informados
func (ggmail *GGMail) Send(refserversmtp GGServerMail) (bool, error) {
	dest := make([]string, 1)
	dest[0] = ggmail.to

	sMessage := "Subject:" + ggmail.cMessage.subject + "\n\n" + ggmail.cMessage.message
	refserversmtp.Serversmtp = strings.TrimSpace(refserversmtp.Serversmtp)
	refserversmtp.Pathserver = strings.TrimSpace(refserversmtp.Pathserver)
	auth := smtp.PlainAuth("", strings.TrimSpace(ggmail.from), strings.TrimSpace(ggmail.pass), refserversmtp.Pathserver)
	err := smtp.SendMail(refserversmtp.Serversmtp,
		auth,
		strings.TrimSpace(ggmail.from),
		dest,
		[]byte(sMessage))

	if err != nil {
		return false, err
	}

	return true, nil

}
