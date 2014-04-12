
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
    res.send(200);
  });

  // POST create a Planet
  app.post('/api/planet/create', function(req, res) {
    
  Planet.create({
    name: req.body.name,
    type: req.body.type,
    temperature: req.body.temperature,
    picture: req.body.picture,
    skyColor: req.body.skyColor,
    longNight: req.body.longNight,
    uv: String
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