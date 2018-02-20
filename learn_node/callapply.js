var person = {
    name: 'kuch bhi',
    greet: function (param) {
        console.log(`Hello ${this.name} ${param}`);
    }
}

person.greet.call({name: 'kuch kuch'}, 'chu');
person.greet.apply({name: 'kuch kuch'}, ['chu1'])