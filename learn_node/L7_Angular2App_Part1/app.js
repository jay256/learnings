var express = require('express');
var app = express();
var mongoose = require('mongoose');
var setupController = require('./controllers/setupController');
var apiController = require('./controllers/apiController');
var promise = mongoose.connect('mongodb://localhost:27018/todosample', 
                                {
                                    useMongoClient: true,
                                    promiseLibrary: require('bluebird')    
                                });

var port = process.env.PORT || 3000;

app.use('/', express.static(__dirname + '/public'));

app.set('view engine', 'ejs');

setupController(app);
apiController(app);

app.listen(port);