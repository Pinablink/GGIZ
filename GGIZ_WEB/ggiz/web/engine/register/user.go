package register

type GgizHardware struct {
	KeyHard  string `json:"keyHard"`
}

type GgizHardwareResponse struct {
	Code uint16     `json:"code"`
	Message string  `json:"message"`
}

type person struct {
	Name  string
	Genre uint8
	Age   uint8
}

type user struct {
	NickName string
	Email    string 
	Password string
}

