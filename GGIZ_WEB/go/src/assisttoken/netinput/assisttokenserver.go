package netinput

import (
	"assisttoken/message"
	"assisttoken/tokenredistrans"
	"encoding/json"
	"fmt"
	"io/ioutil"
	"net/http"
)

var (
	redispath string
)

//InitCtrServerToken Inicializa o Servidor de controle da seed key da aplicação
func InitCtrServerToken(strredisenv string) {
	redispath = strredisenv
	http.HandleFunc("/input/keySeed", inputSeedKeyToken)
	http.HandleFunc("/get/keySeed", getSeedKeyToken)

}

func inputSeedKeyToken(w http.ResponseWriter, r *http.Request) {

	if r.Method == "POST" {
		body, err := ioutil.ReadAll(r.Body)
		defer r.Body.Close()

		if err != nil {
			fmt.Println(message.ERRGETBODY)
		} else {
			inputMessage := message.InputMessage{}
			json.Unmarshal(body, &inputMessage)
			tokenredistrans.ExistSeedKey(redispath, inputMessage)
		}

	} else {
		fmt.Println(message.ERRMETHODREQUEST)
	}

}

func getSeedKeyToken(w http.ResponseWriter, r *http.Request) {

	if r.Method == "GET" {
		getMessage := tokenredistrans.GetKeySeed(redispath)
		fmt.Fprintf(w, getMessage.SeedKey)
	} else {
		fmt.Println(message.ERRMETHODREQUEST)
	}
}
