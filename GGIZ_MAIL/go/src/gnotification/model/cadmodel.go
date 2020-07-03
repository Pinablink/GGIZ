package model

// CadModel Estrutura para inclusão no Banco de Dados Técnico
type CadModel struct {
	Email        string `json:"email"`
	Datainclusao string `json:"datainclusao"`
}

// ErrorModel Estrutura para inclusão no Banco de Dados Técnico
type ErrorModel struct {
	Errormessage string `json:"errormessage"`
	Operacao     string `json:"operacap"`
	Email        string `json:"email"`
	DataInclusao string `json:"datainclusao"`
}
