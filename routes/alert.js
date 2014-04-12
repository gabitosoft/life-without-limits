// Paths to API
module.exports = function (app) {
  var Alert = require('../models/Alert');

  // POST 
  app.post('/api/alert', function(req, res) {
    // Create an Alert
    Alert.create({
      sensor: req.body.sensor,
      planet: req.body.planet,
      date: req.body.date,
      type: req.body.type,
      title: req.body.title,
      token: req.body.token,
      description: req.body.description,
      read: false
    }, function(err, alert) {
      if (err) {
        console.log(err);
        res.send(500, err);
      }

      // Send the alert to the client
      for (var username in app.connections) {
        app.connections[username].emit('alert', alert);
      }
      console.log('alert', alert);
    });
    res.send(200);
  });
};