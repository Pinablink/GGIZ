package work

import (
	"strings"
        "fmt"
)

const (
	keyBroadcast  string = "BROADCAST"
	keyWarningCad string = "WARNING_CAD"
)


//Loadtasks Carrega as tarefas pertinentes ao envio de email
func Loadtasks(binaryData, serverBinary []byte) map[string]worksmtpmail {
        tasks := make(map[string]worksmtpmail, 2)
	broadcast := &broadcast{}
	warningcad := &warningcad{}

	content := string(serverBinary)
	params := strings.Split(content, ",")
	from := params[0]
	password := params[1]

	strServerConf := string(binaryData)
	contentServerConf := strings.Split(strServerConf, ",")

	broadcast.from = from
	broadcast.password = password
	broadcast.contentServerConf = contentServerConf

	warningcad.from = from
	warningcad.password = password
	warningcad.contentServerConf = contentServerConf

	tasks[keyBroadcast] = broadcast
	tasks[keyWarningCad] = warningcad
	fmt.Println(tasks)
	return tasks
}

//Exectask Irá executar a tarefa configurada no ambiente
func Exectask(taskOb map[string]worksmtpmail,  strOrder string) {
       key := strings.TrimSpace(strOrder)
       process, teste := taskOb[key]

	if teste {
	   process.wsend()	
        } else {
          fmt.Println("Processo desconhecido")		
	}
}
