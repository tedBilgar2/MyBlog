var model = "Hello World";

var helloApp = angular.module("helloApp",[]);

helloApp.controller("controller",function ($scope) {
   $scope.message = model;
});