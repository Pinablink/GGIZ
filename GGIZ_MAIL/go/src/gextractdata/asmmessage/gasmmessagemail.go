package asmmessage

import (
	"fmt"
	"log"
	"strings"

	"github.com/gomodule/redigo/redis"
)

var (
	ckeyHash []string
)

// GetMessage Obtem a mensagem formatada com os dados cadastrados no Redis e envia por email
func GetMessage() (bool, string) {
	var messageMail string
	var mapcontent map[string]string
	conn, err := redis.Dial("tcp", "localhost:6379")

	if err != nil {
		log.Fatal(err)
	}

	defer conn.Close()

	mapcontent, err = redis.StringMap(conn.Do("HGETALL", "iCadDay"))

	if err != nil {
		log.Fatal(err)
	}

	i := len(mapcontent)

	if i >= 1 {
		var builderStr strings.Builder
		var builderRef *strings.Builder
		var dtIncluded bool
		var dtIncRef string
		builderStr.WriteString(iniMessage(messageMail))
		builderRef = &builderStr
		fmt.Fprint(builderRef, (i / 2), "\n")
		ckeyHash = make([]string, 0)

		for key, element := range mapcontent {
			keystr := []rune(key)
			keyv := string(keystr[0:(len(key) - 1)])

			if strings.EqualFold(keyv, "Email") {
				fmt.Fprint(builderRef, "Email Informado: ", element, "\n")
				ckeyHash = append(ckeyHash, key)
			} else {
				if !dtIncluded {
					dtIncluded = true
					dtIncRef = element
				}
			}
		}

		fmt.Fprint(builderRef, "Data de Referência: ", dtIncRef, "\n")
		clearHash()
		return true, builderStr.String()
	}

	strRet := "0"
	return false, strRet
}

func clearHash() {
	// Implementar aqui a exclusão dos dados do redis
}

func iniMessage(smessage string) string {
	smessage = "Aviso de Sistema - Cadastro de Usuários\nCadastro(s) realizado(s): "
	return smessage
}
