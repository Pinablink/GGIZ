package netrequest

import (
	"fmt"
	"gnotification/model"
	"log"

	// Inclusao de Modulo
	"github.com/gomodule/redigo/redis"
)

var (
	countCad        uint16 = 0
	emailkey        string
	datainclusaokey string
)

// IncludeCad Irá incluir os Dados no Redis para posterior consulta
func includeCad(m model.CadModel) {

	conn, err := redis.Dial("tcp", "localhost:6379")

	if err != nil {
		log.Fatal(err)
	}

	defer conn.Close()

	emailkey = fmt.Sprintf("%s%d", "Email", countCad)
	datainclusaokey = fmt.Sprintf("%s%d", "Datainclusao", countCad)

	_, err = conn.Do("HMSET", "iCadDay", emailkey, m.Email, datainclusaokey, m.Datainclusao)
	countCad++

	if err != nil {
		log.Fatal(err)
	}

}
