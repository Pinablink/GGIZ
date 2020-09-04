package tokenredistrans

import (
	"assisttoken/message"
	"fmt"

	"github.com/gomodule/redigo/redis"
)

//GetKeySeed Retorna a KeySeed salva para validaçoes do servidor
func GetKeySeed(hostRedis string) message.InputMessage {
	var responseGet message.InputMessage = message.InputMessage{}
	conn, err := redis.Dial("tcp", hostRedis)

	if err != nil {
		fmt.Println(message.ERRCONREDIS)
	} else {
		defer conn.Close()
		response, err := redis.String(conn.Do("HGET", message.HASHSEEDKEYID, message.FIELDKEYSEED))

		if err != nil {
			fmt.Println(message.ERRGETSEEDKEY)
		} else {
			responseGet.SeedKey = response
		}
	}

	return responseGet
}

//ExistSeedKey Verifica se existe no cache a key seed informada
func ExistSeedKey(hostRedis string, refInput message.InputMessage) bool {

	conn, err := redis.Dial("tcp", hostRedis)

	if err != nil {
		fmt.Println(message.ERRCONREDIS)
	} else {
		defer conn.Close()

		response, err := redis.Int(conn.Do("HEXISTS", message.HASHSEEDKEYID, message.FIELDKEYSEED))

		if err != nil {
			fmt.Println(message.ERRSEARCHREDIS)
		} else {
			if response == 0 {
				_, err = conn.Do("HMSET", message.HASHSEEDKEYID, message.FIELDKEYSEED, refInput.SeedKey)

				if err != nil {
					fmt.Println(message.ERRINPUTSEEDKEY)
					fmt.Println(err)
				} else {
					fmt.Println("Informacao Adicionada")
				}

			}
		}
	}

	return false
}
