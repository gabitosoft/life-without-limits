var app = angular.module('webApp', []);
app.factory('socket', function () {
  var socket = io.connect('http://localhost:3000');
  return socket;
});

app.controller('UserController', function($scope, $http) {
  $scope.loginUser = function() {
    $scope.user = {
      email: $scope.email,
      password: $scope.password
    }
    
    $http({
    	method: 'POST',
    	url: 'http://localhost:3000/api/user/login',
    	data: $scope.user
    }).
    success(function (data, status, headers, config) {
      console.log(data);
      console.log('success');
    }).
    error(function (data, status, headers, config) {
      console.log('error');
      console.log(data);
    });
  }

  $scope.signinPage = function() {
    window.location = 'user/new.html';
  }

  $scope.newUser = function() {
    $scope.user = {
      name: $scope.name,
      email: $scope.email,
      password: $scope.password,
      confirmation: $scope.confirmation
    }
    
    $http({
      method: 'POST',
      url: 'http://localhost:3000/api/user/create',
      data: $scope.user
    }).
    success(function (data, status, headers, config) {
      console.log(data);
      console.log('success');
      window.location = '../index.html';
    }).
    error(function (data, status, headers, config) {
      console.log('error');
      console.log(data);
    });
  }  
});
