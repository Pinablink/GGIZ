package gging 


const(
	  len_key_input uint16 = 24
	  erro_len_cod uint16 = 1
	  erro_len string = "Tamanho de Chave Invalido"
	  key_ok string = "Chave informada com sucesso"
)

type Gging struct {
	Vl string
}

// TODO MECANISMO DE VALIDAÇAO SERÁ ADICIONADO AQUI
func (g Gging) ValidKey () (bool, uint16, string) {
	ret := validLen (g.Vl)
	
	if ret == false {
        return ret, erro_len_cod, erro_len
	} 
	
	return ret, 0, key_ok
}

// Rertorna se o tamanho da String obedece a regra e o tamanho computado

func validLen (str string) bool {
    iLen := uint16(len (str))

	if (iLen == len_key_input) {
		return true
	} else {
		return false
	}
}