var express = require('express');
var exphbs  = require('express-handlebars');
var app = express();
var os = require("os");
var morgan  = require('morgan');
const PORT = process.env.PORT || 8080;
const URL = process.env.URL || "http://127.0.0.1:3030/v1/whoami";


app.engine('handlebars', exphbs({defaultLayout: 'main'}));
app.set('view engine', 'handlebars');
app.use(express.static('static'));
app.use(morgan('combined'));

const fetch = require('node-fetch');

// Configuration
// var port = process.env.PORT || 8080;
var message = process.env.MESSAGE || "I 💕 NodeJS!!!";
var lang = "NodeJS"

let settings = { method: "Get" };


app.get('/', function (req, res) {


  (async () => {
    try {
      await fetch(URL, settings)
      .then(res => res.json())
      .then((json) => {
          lang = json.app;
          message = json.message;
      });
    } catch (error) {
      if (error.name === 'AbortError') {
        console.log('request was aborted');
      }
    }
  })();

      res.render('home', {
      message: message,
      platform: os.type(),
      release: os.release(),
      hostName: os.hostname(),
      lang: lang,
    });
});

// Set up listener
app.listen(PORT, function () {
  console.log("Listening on: http://%s:%s", os.hostname(), PORT);
});