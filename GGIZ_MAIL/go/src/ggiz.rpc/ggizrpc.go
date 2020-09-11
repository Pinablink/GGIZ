package main

import (
	"gsmtp/work"
	"log"
	"net"
	"net/rpc"
        "fmt"

	grpcst "ggiz.rpc/rpcst"
)

func main() {

	add, err := net.ResolveTCPAddr("tcp", "localhost:3082")

	if err != nil {
		log.Fatal(err)
	}

	pt, err := net.ListenTCP("tcp", add)

	if err != nil {
		log.Fatal(err)
	}

	grpcst.RefMapInterface = work.LoadTaskWork()
	fmt.Println(grpcst.RefMapInterface)
        listener := new(grpcst.Listener)
	rpc.Register(listener)
	rpc.Accept(pt)
}
