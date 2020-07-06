package netrequest

import (
	"encoding/json"
	"fmt"
	"gnotification/model"
	"io"
	"io/ioutil"
	"log"
	"net/http"
	// Inclusao de Modulo
)

// InitServer Inclui um Callback para a chamada http
func InitServer() {
	http.HandleFunc("/newcadgo", inputDataCad)
	http.HandleFunc("/getcadgo", getDataCad)
}

func getDataCad(w http.ResponseWriter, r *http.Request) {

}

func inputDataCad(w http.ResponseWriter, r *http.Request) {
	if r.Method == "POST" {

		body, err := ioutil.ReadAll(r.Body)
		defer r.Body.Close()

		if err != nil {
			// Melhorar o mecanismo de log...
			log.Fatal("Erro ao obter o corpo da solicitação")
		} else {
			cadModel := model.CadModel{}
			json.Unmarshal(body, &cadModel)
			includeCad(cadModel)
			fmt.Println("Dado Cadastrado com sucesso")
		}

		io.WriteString(w, "Teste")
	}
}

func inputDataError(w http.ResponseWriter, r *http.Request) {
	if r.Method == "POST" {
		// IRA EFETUAR O CADASTRO NA TABELA DE ERROS - AINDA EM DESENVOLVIMENTO
	}
}
