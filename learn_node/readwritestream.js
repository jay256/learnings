var fs = require('fs');
var zlib = require('zlib');


var readable = fs.createReadStream(__dirname + '/greet.txt'); //, {encoding: 'utf-8', highWaterMark: 16*2024}

var writable = fs.createWriteStream(__dirname + '/greetcopy.txt');

/*readable.on('data', function(chunk){
    console.log(chunk);
    writable.write(chunk);
})*/

var compressed = fs.createWriteStream(__dirname + '/greet.txt.gz');

var gzip = zlib.createGzip();

readable.pipe(gzip).pipe(compressed);