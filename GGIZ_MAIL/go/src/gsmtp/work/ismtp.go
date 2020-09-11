package work

//Worksmtpmail Interface que irá conter o tipo de email que deverá ser enviado.
type Worksmtpmail interface {
	Wsend() (bool, error)
}
