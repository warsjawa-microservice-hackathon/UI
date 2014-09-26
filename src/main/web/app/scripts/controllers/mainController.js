'use strict';

/**
 * @ngdoc function
 * # MainCtrl
 */
angular.module('BootstrapApplication.controllers')
        .controller('MainCtrl', ['$scope', 'CityService', 'ClientService', function ($scope, CityService, ClientService) {
            $scope.awesomeThings = [
                'HTML5 Boilerplate',
                'AngularJS',
                'Karma'
            ];


            $scope.client = {
                name: 'Joe',
                surename: 'Doe',
                age: 25,
                job: 'IT',
                amount: 2500
            };


            $scope.lat = '62.232222';
            $scope.lon = '21.008333';

            $scope.alerts = [];

            $scope.city = '';

            $scope.findCity = function() {
                CityService.findCity($scope.lat, $scope.lon, function(data) {
                    $scope.city = data;
                });
            };

            $scope.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };

            $scope.applyForLoan = function() {
                ClientService.applyForLoan($scope.client, function(id) {
                   console.log(id);
                });
            };
            $scope.applyForLoan();
        }]);
