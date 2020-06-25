package mail

import (
	"fmt"
	"log"
	"strings"
	"net/smtp"
)

// Send Envia email utilizando os parâmetros informados
func (ggmail *GGMail) Send(refserversmtp GGServerMail) {
	dest := make([]string, 1)
	dest[0] = ggmail.to

	sMessage := "Subject:" + ggmail.cMessage.subject + "\n\n" + ggmail.cMessage.message
        refserversmtp.Serversmtp = strings.TrimSpace(refserversmtp.Serversmtp)
	refserversmtp.Pathserver = strings.TrimSpace(refserversmtp.Pathserver)
	
	err := smtp.SendMail(refserversmtp.Serversmtp,
		smtp.PlainAuth("", ggmail.from, ggmail.pass, refserversmtp.Pathserver),
		ggmail.from,
		dest,
		[]byte(sMessage))

	if err != nil {
		log.Fatal(err)
	} else {
		fmt.Println("Email enviado...")
	}

}
