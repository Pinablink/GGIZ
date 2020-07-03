package netrequest

import (
	"fmt"
	"gnotification/model"
	"log"

	// Inclusao de Modulo
	"github.com/gomodule/redigo/redis"
)

var (
	countCad int = 0
)

// IncludeCad Irá incluir os Dados no Redis para posterior consulta
func IncludeCad(m model.CadModel) {
	conn, err := redis.Dial("tcp", "localhost:6379")

	if err != nil {
		log.Fatal(err)
	}

	defer conn.Close()

	_, errret := conn.Do("HMSET", "iCadDay:", "Email", m.Email, "Datainclusao", m.Datainclusao)
	countCad++
	fmt.Printf("%d", countCad)
	if errret != nil {
		log.Fatal(errret)
	}
}
