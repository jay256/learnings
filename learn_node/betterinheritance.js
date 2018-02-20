var utils=require('util');

function Person(){
    this.firstname ='';
    this.lastname ='';
}

Person.prototype.greet = function(){
    console.log(`Hello ${this.firstname} ${this.lastname}`);
}

function Policeman(){
    Person.call(this);
    this.badgeNumber = '1234';
}

utils.inherits(Policeman, Person);

var officer = new Policeman();
officer.firstname = 'Mat';
officer.lastname = 'Hayden';
officer.greet();




