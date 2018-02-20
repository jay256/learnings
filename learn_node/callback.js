function f(cb){
    console.log("f");
    cb();
}

f(function(){
    console.log("cb1");
})

f(function(){
    console.log("cb2");
})

f(function(){
    console.log("cb3");
})
