var express = require('express');
var app = express();

var port = process.env.port || 3000;

app.get('/', function(req, res){
    res.send('<html><body><h1>Hello World!</h1></body></html>');
});

app.get('/api', function(req, res){
    res.send({firstname: 'Jay', lastname: 'Bhardwaj'});
});

app.listen(port);




