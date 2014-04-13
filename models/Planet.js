/**
 * Planet
 *
 * @module      :: Model
 * @description :: A short summary of how this model works and what it represents.
 * @docs		::
 */

var mongoose = require('mongoose');

module.exports = mongoose.model('planet', {

  name: String,
  type: String,
  temperature: String,
  skyColor: String,
  longNight: String,
  uv: String
});

