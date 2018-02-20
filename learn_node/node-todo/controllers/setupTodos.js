var Todos = require('../models/todoModels');

module.exports = function (app) {
    app.get('/api/setupTodos', function (req,res) {
       var starterTodos = [
           {
               username: 'test',
               todo: 'buy milk',
               isDone: 'false',
               hasAttachment: 'false'
           },
           {
               username: 'test',
               todo: 'feed dog',
               isDone: 'false',
               hasAttachment: 'false'
           },
           {
               username: 'test',
               todo: 'learn node',
               isDone: 'false',
               hasAttachment: 'false'
           },
       ];
       Todos.create(starterTodos, function(err,results){
           res.send(results);
       });
    });
};