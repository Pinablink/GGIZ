package message

// Mensagens do sistema
const (
	FIELDKEYSEED     string = "KEY_SEED_TOKEN_SERVER"
	HASHSEEDKEYID    string = "ID_SEED_KEY_HASH_SERVER"
	ERRGETBODY       string = "SPRING_ORIGIN_ERR_INPUT_SEED_KEY"
	ERRMETHODREQUEST string = "METHOD_REQUEST_NOT_AUTHORIZED"
	ERRCONREDIS      string = "NOT_CON_REDIS_GGIZ_CACHE"
	ERRSEARCHREDIS   string = "ERR_SEARCH_SEED_KEY_REDIS_GGIZ"
	ERRINPUTSEEDKEY  string = "ERR_INPUT_SEED_KEY"
	ERRGETSEEDKEY    string = "ERR_GET_KEY_SEED"
)

//InputMessage Contem a chave usada pelo servidor para gerar o token
type InputMessage struct {
	SeedKey   string `json:"seedKey"`
	DateInput string `json:"dateInput"`
}
