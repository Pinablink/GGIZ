package work

import (
	"fmt"
	"gsmtp/mail"
	"strings"

	recipient "ggiz.recipient/ggiz.recipient.service"
)

type broadcast struct {
	from              string
	password          string
	contentServerConf []string
}

func (ref *broadcast) wsend() {
	var smtpMail mail.GGServerMail
	var robotMail mail.GGMail

	var mrecipient recipient.GroupUserReceptor

	mrecipient = recipient.GetListRecipient()
	var strMessage string = mrecipient.Message
	var listUserDest []recipient.UserReceptor = mrecipient.ListUserDest

	if len(listUserDest) > 0 && len(strMessage) > 0 {
		strMessage = strings.TrimSpace(strMessage)
		var countMail uint = 0
		var strSubject string = "[GGIZ] Olá!! Tenho novidades!"
		smtpMail.Serversmtp = ref.contentServerConf[0]
		smtpMail.Pathserver = ref.contentServerConf[1]

		for _, userReceptorRef := range listUserDest {
			robotMail.Config(ref.from, ref.password, strings.TrimSpace(userReceptorRef.Email), strSubject, strMessage)
			robotMail.Send(smtpMail)
			countMail++
		}

		fmt.Printf("Sistema de Broadcast processou com o envio de %d email", countMail)
	}

}
