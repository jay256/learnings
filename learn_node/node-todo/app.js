var express = require('express');
var app = express();
var mongoose = require('mongoose');
var setupController = require('./controllers/setupTodos');

var promise = mongoose.connect('mongodb://localhost:27018/todosample', 
                                {
                                    useMongoClient: true,
                                    promiseLibrary: require('bluebird')    
                                });

var port = process.env.PORT || 3000;

app.use('/assets', express.static(__dirname + '/public'));

app.set('viewengine','ejs');

promise.then(setupController(app));

app.listen(port);