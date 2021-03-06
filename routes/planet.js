
// Paths to API
module.exports = function (app) {

  var Planet = require('../models/Planet');

  // GET for Planets
  app.get('/api/planet', function(req, res) {
    Planet.find(function(err, planets) {
      if (err) {
        res.send(err);
      }
      res.json(planets);
    });
  });

  // POST create a Planet
  app.post('/api/planet/create', function(req, res) {
    
  Planet.create({
    name: req.body.name,
    type: req.body.type,
    temperature: req.body.temperature,
    skyColor: req.body.sky,
    longNight: req.body.longNight,
    uv: req.body.uv
  }, function(err) {
      if (err) {
        res.send(err);
      }
  });

    res.send(200);
  });

  // DELETE an specific Planet
  app.delete('/api/planet/:id', function(req, res){
    Planet.remove({
      _id: req.params.id
    }, function(err, user){
      if (err) {
        res.send(err);
      }
      planet.find(function(err, users){
        if (err) {
          res.send(err);
        }
        res.json(planets);
      });
    });
  });
};