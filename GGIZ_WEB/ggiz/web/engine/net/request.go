package ggizRequest

import (
	    "fmt"
		"io"
		"net/http"
		"io/ioutil"
		"encoding/json"
		"ggiz/web/engine/register"
		"ggiz/web/engine/content"
       )


func InitServer () bool {
	createHome ()
	//Cadastro de Handles
	http.HandleFunc ("/codKeyInput", inputKey)
	http.HandleFunc ("/status", getStatusGGIZHard)
	return true
}

func createHome () {
	fs := http.FileServer (http.Dir("../../page/"))
	http.Handle ("/", fs)
}

// Terá de Receber xxxx.xxxx.xxxx.xxxx.xxxx
func inputKey (w http.ResponseWriter, r *http.Request) {

	fmt.Println("Recebida Requisiçao...")

    if r.Method ==  "POST" {
		
		b, err := ioutil.ReadAll (r.Body)
		defer r.Body.Close()

		if err != nil {
			io.WriteString (w, "ERRO - Definir 1")	
		} else {
			var ggizHardware register.GgizHardware
			var mgging gging.Gging 
			json.Unmarshal (b, &ggizHardware)
			// Chamada do validador
			mgging.Vl = ggizHardware.KeyHard
			ok, cod, msg := mgging.ValidKey()
		   
			var responseHardware register.GgizHardwareResponse
			responseHardware.Code = cod
			responseHardware.Message = msg

            ret, _ := json.Marshal (&responseHardware)

			if ok == true {
				io.WriteString (w, string(ret))
			}  else {
				io.WriteString (w, string(ret))
			}

		}

	} else {
		io.WriteString (w, "Metodo inesperado")
	}

}

func getStatusGGIZHard (w http.ResponseWriter, r *http.Request) {
	
	if r.Method == "GET" {
		io.WriteString (w, "Status: Em Desenvolvimento....")
	} else {
		io.WriteString (w, "Metodo inesperado")
	}
		
}