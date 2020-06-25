package mail

// GGServerMail Contem os dados de informação do servidor smtp
type GGServerMail struct {
	Serversmtp string
	Pathserver string
}

type gMessage struct {
	subject string
	message string
}

// GGMail Contem a estrutura necessaria para permitir o envio de um email
type GGMail struct {
	from     string
	to       string
	datH     string
	pass     string
	cMessage gMessage
}
