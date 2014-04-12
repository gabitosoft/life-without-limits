/**
 * Alert
 *
 * @module      :: Model
 * @description :: A short summary of how this model works and what it represents.
 * @docs		::
 */

var mongoose = require('mongoose');

module.exports = mongoose.model('alert', {
  sensor: String,
  date: String,
  title: String,
  token: String,    
  read: Boolean,
  type: String,
  planetName: String
});

