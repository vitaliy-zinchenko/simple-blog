define(['angular', 'common/services', 'services'],
    function(ng, commonServices, services) {

        var directives = angular.module('gameConstructorDirectives', []);

        directives.directive('desktop', ['$log', '$rootScope', function($log, $rootScope) {
            return {
                restrict: 'A',
                link: function(session, elm, attr){
                    $rootScope.desktop = {
                        x : elm.position().left,
                        y : elm.position().top
                    };
                    $log.debug('desktop');
                }
            }
        }]);

        return directives;
    });