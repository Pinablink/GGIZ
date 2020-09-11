package work

import (
	"gsmtp/engine"
)

//LoadTaskWork Realiza a Carga das Tarefas de natureza de envio de email
func LoadTaskWork() map[string]Worksmtpmail {

	serverBinary, binaryData, _ := engine.GetDataConfMail()
	return loadtasks(binaryData, serverBinary)
	//fmt.Println(" --- Verificando transporte objeto ")
	//fmt.Println(mmap)
	//Exectask(mmap, order)
	//}
}
