'use strict';

angular.module('BootstrapApplication.services')
    .factory('CityService', ['$http', function($http) {
        var cityService = {};
        cityService.findCity = function (lat, lon, successFn) {
            $http({
                url: '/city/'+lat+'/'+lon,
                dataType: 'json',
                method: 'POST',
                data: '',
                headers: {
                    'Content-Type': 'application/vnd.com.ofg.twitter-places-analyzer.v1+json'
                }
            }).success(function (data) {
                successFn(data);
            });
        };

        return cityService;
    }
]);

angular.module('BootstrapApplication.services')
    .factory('ClientService', ['$http', function($http) {
        var clientService = {};
        clientService.applyForLoan = function (client, successFn) {
        console.log(client);
            $http({
                url: '/client/loan/',
                dataType: 'json',
                method: 'POST',
                data: client
//                    client
            }).success(function (data) {
                successFn(data);
            });
        };

        return clientService;
    }
    ]);