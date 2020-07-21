package work

import "fmt"

type broadcast struct {
	from              string
	password          string
	contentServerConf []string
}

func (ref *broadcast) wsend() {
	fmt.Println("Regra deverá ser implementada - Em desenvolvimento")
	fmt.Println("Enviando aviso aos cadastrados")
}
