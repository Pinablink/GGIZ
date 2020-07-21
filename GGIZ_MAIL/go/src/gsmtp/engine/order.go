package engine

import (
	"io/ioutil"
	"os"
)

// GetOrder Obtém do Ambiente a Ordem de trabalho.
func GetOrder() (string, error) {
	path := os.Getenv("GGSMTP")
	binarycontent, errwork := ioutil.ReadFile(path)

	if errwork != nil {
		return "", errwork
	}

	strcontent := string(binarycontent)
	return strcontent, nil
}

//GetDataConfMail Retornar os dados de conexão com o servidor de email
func GetDataConfMail() ([]byte, []byte, error) {
	pathEmailConfig := os.Getenv("MAIL_CONFIG")
	serverEmailConfig := os.Getenv("SERVER_MAIL_CONFIG")
	serverBinary, errserver := ioutil.ReadFile(serverEmailConfig)
	binaryData, err := ioutil.ReadFile(pathEmailConfig)

	if errserver != nil {
		return nil, nil, errserver
	} else if err != nil {
		return nil, nil, err
	}

	return binaryData, serverBinary, nil
}
