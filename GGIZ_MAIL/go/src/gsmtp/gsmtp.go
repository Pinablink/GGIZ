package main

import (
	"fmt"
	"gsmtp/mail"
	"io/ioutil"
	"log"
	"os"
	"strings"
	"time"
)

func main() {
	fmt.Println("Iniciado gsmtp - Para Envio de Email")
	fmt.Println("Dt|Hr : ", time.Now())
	pathEmailConfig := os.Getenv("MAIL_CONFIG")
	serverEmailConfig := os.Getenv("SERVER_MAIL_CONFIG")
	serverBinary, errserver := ioutil.ReadFile(serverEmailConfig)
	binaryData, err := ioutil.ReadFile(pathEmailConfig)

	if errserver != nil {
		log.Fatal(errserver)
	} else {
		if err != nil {
			log.Fatal(err)
		} else {
			content := string(binaryData)
			params := strings.Split(content, ",")
			from := params[0]
			password := params[1]

			strServerConf := string(serverBinary)
			contentServerConf := strings.Split(strServerConf, ",")

			var smtpMail mail.GGServerMail
			var robotMail mail.GGMail
			smtpMail.Serversmtp = contentServerConf[0]
			smtpMail.Pathserver = contentServerConf[1]
			// Ponto deverá ser modificado. Este conteúdo será proveniente de uma chamada REST em um Serviço Spring Boot
			robotMail.Config(from, password, "pinablink@hotmail.com", "Novo Envio de Mensagem")
			robotMail.Send(smtpMail)
		}
	}

}
