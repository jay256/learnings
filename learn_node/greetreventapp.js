'use strict';

var greetr = require('./greetrevent');

var Greetr = new greetr();

Greetr.on('greet',function(data){
    console.log(`Someone greeted ${data}`);
})

Greetr.greet('YOLO');