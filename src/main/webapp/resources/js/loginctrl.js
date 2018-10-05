/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var app = angular.module('ti', []);
app.controller('loginctrl', function ($scope, $http) {
    var self = this;
    self.submit = function () {
        var data = {
            emailID: $scope.emailID,
            password: $scope.password,
            message: null,
            status: false
        };
        alert("DATA " + $scope.contextpath);
        alert("Daa " + $scope.emailID + "< " + data.emailID);
        $http.post($scope.contextpath+"/checklogin",JSON.stringify(data)).then(function (response){
           alert(response.data); 
        });
    };
});