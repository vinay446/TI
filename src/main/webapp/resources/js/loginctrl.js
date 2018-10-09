/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var app = angular.module('ti', []);
app.controller('loginctrl', function ($scope, $http) {
    var self = this;
    self.submit = function () {
        $scope.loading = true;
        var data = {
            emailID: $scope.emailID,
            password: $scope.password,
            message: null,
            status: false,
            rememberme: $scope.rememberme
        };
        $http.post($scope.contextpath + "/checklogin", JSON.stringify(data)).then(function (response) {
            var data = response.data;
            var status = data.status;
            var message = data.message;
            $scope.message = message;
            if (!status) {
                $scope.loading = false;
                return;
            }
            location.href = $scope.contextpath + "/home";
        }, function (response) {
            $scope.loading = false;
            $scope.message= "ERROR in Connecting to server..";
        });
    };
});