package asmmessage

import (
	"fmt"
	"gutil"
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

	mapcontent, err = redis.StringMap(conn.Do("HGETALL", gutil.GetLastDateKeyHash()))
	// Para testes antes da implantação
	// mapcontent, err = redis.StringMap(conn.Do("HGETALL", gutil.GetDateKeyHash()))

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
			} else if strings.EqualFold(keyv, "Datainclusao") {
				ckeyHash = append(ckeyHash, key)
				if !dtIncluded {
					dtIncluded = true
					dtIncRef = element
				}
			}
		}

		fmt.Fprint(builderRef, "Data de Referencia: ", dtIncRef, "\n")
		processArrayHash(conn)

		return true, builderStr.String()
	}

	strRet := "0"
	return false, strRet
}

func processArrayHash(refConn redis.Conn) {
	var emailP string
	var dataIncP string
	j := len(ckeyHash)

	for i := 0; i < j; i++ {
		vlTarget := ckeyHash[i]

		if strings.Contains(vlTarget, "Email") {
			emailP = vlTarget
		} else if strings.Contains(vlTarget, "Datainclusao") {
			dataIncP = vlTarget
			clearHash(emailP, dataIncP, refConn)
		}
	}

}

func clearHash(strEmail, strData string, refConn redis.Conn) {

	_, err := refConn.Do("HDEL", gutil.GetDateKeyHash(), strEmail, strData)

	if err != nil {
		log.Fatal("Ocorreu Erro na Exclusao de Itens do Hash", err)
	}
}

func iniMessage(smessage string) string {
	smessage = "Aviso de Sistema - Cadastro de Usuarios\nCadastro(s) realizado(s): "
	return smessage
}
