
// Paths to API
module.exports = function (app) {

  var Planet = require('../models/Sensor');

  // GET for Planets
  app.get('/api/sensor', function(req, res) {
    Sensor.find(function(err, sensors) {
      if (err) {
        res.send(err);
      }
      res.json(sensors);
    });
    res.send(200);
  });

  // POST create a Planet
  app.post('/api/sensor/create', function(req, res) {
    
  Sensor.create({
    name: req.body.name,
    planet: req.body.planet
  }, function(err) {
      if (err) {
        res.send(err);
      }
  });

    res.send(200);
  });

  // DELETE an specific Planet
  app.delete('/api/sensor/:id', function(req, res) {
    Sensor.remove({
      _id: req.params.id
    }, function(err, user) {
      if (err) {
        res.send(err);
      }

      Sensor.find(function(err, sensors) {
        if (err) {
          res.send(500, err);
        }
        res.json(sensors);
      });
    });
  });
};