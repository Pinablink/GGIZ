package work

import (
	"strings"
)

const (
	keyBroadcast  string = "BROADCAST"
	keyWarningCad string = "WARNING_CAD"
)

func loadtasks(binaryData, serverBinary []byte) map[string]Worksmtpmail {
	tasks := make(map[string]Worksmtpmail, 2)
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
	return tasks
}
