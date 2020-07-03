package main

import (
	"gnotification/netrequest"
	"log"
	"net/http"
)

func main() {
	netrequest.InitServer()
	log.Fatal(http.ListenAndServe(":3000", nil))
}
