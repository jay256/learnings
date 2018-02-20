'use strict';

class Person{
    constructor(firstname,lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    greet(){
        console.log('Hello '+this.firstname + ' '+this.lastname);
    }
}

var John = new Person('John','Doe');
John.greet();

var Jane = new Person('Jane','Doe');
Jane.greet();

console.log(John.__proto__)
console.log(John.__proto__)
console.log(John.__proto__ === Jane.__proto__)