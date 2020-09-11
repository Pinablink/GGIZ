package main

import (
	"fmt"
	"gsmtp/engine"
	"log"
	"net/rpc"

	grpcst "ggiz.rpc/rpcst"
)

func main() {

	order, err := engine.GetOrder()

	if err != nil {
		log.Fatal(err)
	} else {
		client, err := rpc.Dial("tcp", "localhost:3082")

		if err != nil {
			log.Fatal(err)
		}

		var refFuncWork grpcst.RemoteInterface
		err = client.Call("Listener.GetWorkTaskMail", order, &refFuncWork)

		if err != nil {
			log.Fatal(err)
		}

		fmt.Println(refFuncWork.Processado)
		fmt.Println(refFuncWork.Message)
	}
}
