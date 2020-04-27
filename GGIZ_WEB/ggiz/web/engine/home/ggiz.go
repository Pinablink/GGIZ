package main

import (
           "fmt"
           "log"
           "net/http"
           "ggiz/web/engine/net"
          )

func main () {
 
  result := ggizRequest.InitServer()

 if result == true {
   fmt.Println ("Executando GGIZ....")
   log.Fatal(http.ListenAndServe(":8080", nil))
 } else {
   fmt.Println ("Ocorreu algum problema na inicializaçao dos recursos")
 }

}
