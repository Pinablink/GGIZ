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

func (ref *broadcast) Wsend() (bool, error) {
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
			mmail := strings.TrimSpace(userReceptorRef.Email)
			fmt.Println("Email Processado e Pronto Para ser enviado")
			fmt.Println(mmail)
			robotMail.Config(ref.from, ref.password, mmail, strSubject, strMessage)
			ok, err := robotMail.Send(smtpMail)

			if err != nil {
				fmt.Println(err)
				return ok, err
			}

			countMail++
		}

		fmt.Println("Quantidade de Email enviado pelo sistema")
		fmt.Println(countMail)
		fmt.Println("---------------------------------------------------")
	}

	return true, nil
}
