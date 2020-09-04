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
	netinput.InitCtrServerToken(ggizRedisPath)
	fmt.Println("GGIZ - Assistente de Seguranca")
	log.Fatal(http.ListenAndServe(strPortServe, nil))
}
