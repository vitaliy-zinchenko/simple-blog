define(['angular', 'angularResource', 'common/services'],
    function(ng, ngResource, commonServices){

        var services = angular.module('GameConstructorServices', ['ngResource', 'commonServices']);

        services.factory('GameConfig', ['$resource', function ($resource) {
            var GameConfig = $resource('/api/gameConfig/:_id', {
                _id:'@id'
            }, {
                _get: {
                    method: 'GET'
                },
                update: {
                    method: 'PUT'
                }
            });

            return GameConfig;
        }]);



});
