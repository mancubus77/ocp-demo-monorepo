// main.go
package main

import (
	"encoding/json"
	"fmt"
	"log"
	"net/http"

	"github.com/gorilla/mux"
)

// Response structure
type ResponseBody struct {
	App     string `json:"app"`
	Message string `json:"message"`
}

var ResponseBodyArr []ResponseBody

func whoAmI(w http.ResponseWriter, r *http.Request) {
	for _, article := range ResponseBodyArr {
		json.NewEncoder(w).Encode(article)
	}
}

func handleRequests() {
	fmt.Println("Starting Go Web  Server *:3030")
	myRouter := mux.NewRouter().StrictSlash(true)
	myRouter.Use(commonMiddleware)
	myRouter.HandleFunc("/v1/whoami", whoAmI)
	log.Fatal(http.ListenAndServe(":3030", myRouter))
}

func commonMiddleware(next http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		w.Header().Add("Content-Type", "application/json")
		w.Header().Add("Access-Control-Allow-Origin", "*")
		next.ServeHTTP(w, r)
	})
}

func main() {
	ResponseBodyArr = []ResponseBody{
		ResponseBody{App: "golang", Message: "I 💕 GoLang!!!"},
	}
	handleRequests()
}
