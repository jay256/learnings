var emitter = require('events');
var config = require('./config');

var emtr = new emitter();

emtr.on(config.GREET, function(){
    console.log('Somewhere, someone said hola');
});

console.log('hello');

emtr.emit(config.GREET);