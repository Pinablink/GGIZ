package mail

import "fmt"

var isValidFromMail bool
var isValidToMail bool
var isValidMessageMail bool
var isValidPassword bool

// Config Informa os dados necessários para que seja enviado um email no sistema
func (ggmail *GGMail) Config(dados ...string) {
	ggmail.inputRemet(dados[0])
	ggmail.inputPassword(dados[1])
	ggmail.inputDest(dados[2])
	ggmail.inputMessage(dados[3], dados[4])
	showConsoleResultConfig()
}

func (ggmail *GGMail) inputRemet(vRemet string) {
	ggmail.from = vRemet
	isValidFromMail = true // Acrescentar melhoria aqui
}

func (ggmail *GGMail) inputPassword(vPassword string) {
	ggmail.pass = vPassword
	isValidPassword = true // Acrescentar melhoria aqui
}

func (ggmail *GGMail) inputDest(vDest string) {
	ggmail.to = vDest
	isValidToMail = true // Acrescentar melhoria aqui
}

func (ggmail *GGMail) inputMessage(subject, vMessage string) {
	var refMessage gMessage
	refMessage.subject = subject
	refMessage.message = vMessage
	ggmail.cMessage = refMessage
	isValidMessageMail = true
}

func showConsoleResultConfig() {
	fmt.Println()
	showRemetMessage(isValidFromMail)
	showDestMessage(isValidToMail)
	showValidMessage(isValidMessageMail)
}
