/**
 * User
 *
 * @module      :: Model
 * @description :: A short summary of how this model works and what it represents.
 * @docs		::
 */

var mongoose = require('mongoose');

module.exports = mongoose.model('user', {
  name: String,
  email: String,
  encryptedPassword: String,
  online: Boolean,
  maxTemperature: String,
  minTemperature: String
});

