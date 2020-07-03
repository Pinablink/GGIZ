package main

import (
	"fmt"
	"log"

	"github.com/gomodule/redigo/redis"
)

/*type cadmoderedis struct {
	Email        string `redis:"email"`
	Datainclusao string `redis:"datainclusao"`
}*/

func main() {

	conn, err := redis.Dial("tcp", "localhost:6379")

	if err != nil {
		log.Fatal(err)
	}

	defer conn.Close()

	email, merr := redis.String(conn.Do("HGET", "iCadDay", "Email"))

	if merr != nil {
		log.Fatal(merr)
	}

	fmt.Println(email)
}
