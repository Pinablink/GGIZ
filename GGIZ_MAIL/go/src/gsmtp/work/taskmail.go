package work

import "strings"

const (
	keyBroadcast  string = "#BROADCAST"
	keyWarningCad string = "#WARNING_CAD"
)

var (
	tasks map[string]worksmtpmail
)

//Loadtasks Carrega as tarefas pertinentes ao envio de email
func Loadtasks(binaryData, serverBinary []byte) {

	tasks = make(map[string]worksmtpmail, 2)
	broadcast := &broadcast{}
	warningcad := &warningcad{}

	content := string(binaryData)
	params := strings.Split(content, ",")
	from := params[0]
	password := params[1]

	strServerConf := string(serverBinary)
	contentServerConf := strings.Split(strServerConf, ",")

	broadcast.from = from
	broadcast.password = password
	broadcast.contentServerConf = contentServerConf

	warningcad.from = from
	warningcad.password = password
	warningcad.contentServerConf = contentServerConf

	tasks[keyBroadcast] = broadcast
	tasks[keyWarningCad] = warningcad
}

//Exectask Irá executar a tarefa configurada no ambiente
func Exectask(strOrder string) {
	tasks[strOrder].wsend()
}
