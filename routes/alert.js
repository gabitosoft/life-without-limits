// Paths to API
module.exports = function (app) {
  var Alert = require('../models/Alert');
  var User = require('../models/User');

  // POST 
  app.post('/api/alert', function(req, res) {
    // Create an Alert
    Alert.create({
      sensor: req.body.sensor,
      planet: req.body.planet,
      date: req.body.date,
      type: req.body.type,
      temperature: req.body.temperature,
      token: req.body.token,
      description: req.body.description,
      read: false,
      skyColor: req.body.skyColor
    }, function(err, alert) {
      if (err) {
        console.log(err);
        res.send(500, err);
      }

        // Send the alert to the client
        for (var username in app.connections) {

          User.findOne({ email: username }, function(err, user) {

            if (!user) {
                res.send(500, 'User not found');
                return ;
            }

            console.log(user);
            if (  ( user.maxTemp != '' && user.minTemp != '' &&
                  req.body.temperature <= user.maxTemp && 
                  user.minTemp <= req.body.temperature) || 
                ( user.skyColor != '' && user.skyColor == req.body.skyColor)) {

              app.connections[username].emit('alert', alert);
            }
          });
        }
       console.log('alert', alert);
    });
    res.send(200);
  });


  // GET for Users
  app.get('/api/alert', function(req, res) {
    Alert.find(function(err, alerts) {
      if (err) {
        res.send(err);
      }
      res.json(alerts);
    });
  });
};