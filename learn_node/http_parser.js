var http = require('http');
var fs = require('fs');

http.createServer(function(req, res){
    res.writeHead(200, {'content-type':'text/html'});
    var html = fs.readFileSync(__dirname + '/index.html');
    res.end(html);
}).listen(5000, '127.0.0.1');