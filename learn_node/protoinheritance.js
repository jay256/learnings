function Person(){
    this.firstname = '';
    this.lastname = '';
}

Person.prototype.greet=function(){
    console.log('Hello ' + this.firstname + ' ' + this.lastname);
}

var John = new Person();
John.firstname = 'John';
John.lastname = 'Doe';
John.greet();

var Jane = new Person();
Jane.firstname = 'Jane';
Jane.lastname = 'Doe';
Jane.greet();

console.log(John.__proto__)
console.log(John.__proto__)
console.log(John.__proto__ === Jane.__proto__)
