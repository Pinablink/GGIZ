package main

import (
	"assisttoken/netinput"
	"fmt"
	"log"
	"net/http"
	"os"
)

func main() {
	var strPortServe string = os.Getenv("KEY_SEED_PORT_TOKEN_GGIZ")
	var ggizRedisPath string = os.Getenv("GGIZ_REDIS_PATH_ENVIRONMENT")

	if len(strPortServe) > 0 && len(ggizRedisPath) > 0 {
		fmt.Println("Recursos do Ambiente obtidos com sucesso")
		netinput.InitCtrServerToken(ggizRedisPath)
		fmt.Println("GGIZ - Assistente de Seguranca")
		log.Fatal(http.ListenAndServe(strPortServe, nil))
	} else {
		fmt.Println("Ocorreu um problema na obtenção das variaveis de ambiente...")
	}

}
