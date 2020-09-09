package mail

import (
	"fmt"
	"log"
	"net/smtp"
	"strings"
)

// Send Envia email utilizando os parâmetros informados
func (ggmail *GGMail) Send(refserversmtp GGServerMail) {
	dest := make([]string, 1)
	dest[0] = ggmail.to

	sMessage := "Subject:" + ggmail.cMessage.subject + "\n\n" + ggmail.cMessage.message
	refserversmtp.Serversmtp = strings.TrimSpace(refserversmtp.Serversmtp)
	refserversmtp.Pathserver = strings.TrimSpace(refserversmtp.Pathserver)

	/*fmt.Println(ggmail.cMessage.subject)
	fmt.Println(refserversmtp.Serversmtp)
	fmt.Println(ggmail.from)
	fmt.Println(ggmail.pass)
	fmt.Println(refserversmtp.Pathserver)
	fmt.Println(dest)
	fmt.Println(sMessage)

	fmt.Println("")
	fmt.Println("")
	fmt.Println("")
	fmt.Println("")*/

	auth := smtp.PlainAuth("", ggmail.from, ggmail.pass, refserversmtp.Pathserver)
	err := smtp.SendMail(refserversmtp.Serversmtp,
		auth,
		ggmail.from,
		dest,
		[]byte(sMessage))

	if err != nil {
		log.Fatal(err)
	} else {
		fmt.Println("Email enviado...")
	}

}
