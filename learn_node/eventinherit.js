var EventEmitter = require('events');
var Util = require('util');

function Greetr(){
    this.greeting = 'Hello world!'
}

Util.inherits(Greetr, EventEmitter);

Greetr.prototype.greet = function(data){
    console.log(this.greeting);
    this.emit('greet',data);
}

var Greetr1 = new Greetr();

Greetr1.on('greet', function(data){
    console.log('Someone greeted: '+data);
})

Greetr1.greet('Hola');