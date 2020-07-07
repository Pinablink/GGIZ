package gutil

import (
	"time"
)

// GetDateKeyHash Retorna uma String com a data atual do
// sistema no formato YYYY-mm-dd para servir como chave do Hash de
// mapeamento de inclusão de cadastros em determinado dia
func GetDateKeyHash() string {
	const formatDate = "2006-01-02"
	aTime := time.Now()
	return aTime.Format(formatDate)
}

// GetLastDateKeyHash Chave de Hash com a data anterior
func GetLastDateKeyHash() string {
	const formatDate = "2006-01-02"
	var time1 = time.Now()
	time1 = time1.AddDate(0, 0, -1)
	return time1.Format(formatDate)
}
