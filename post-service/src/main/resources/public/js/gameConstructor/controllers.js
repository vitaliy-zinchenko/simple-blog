define(['angular', 'common/services', 'services', 'angularDraggable',
    'directives'],
    function(ng, commonServices, services, angularDraggable,
             directives) {

        var controllers = angular.module('gameConstructorControllers',
            ['commonServices', 'GameConstructorServices', 'ngDraggable',
                'gameConstructorDirectives']);

        controllers.controller("GameList", ['$scope', 'GameConfig',
            function($scope, GameConfig){
                $scope.games = GameConfig.query();
        }]);

        controllers.controller("CreateGame", ['$scope', 'GameConfig',
            function($scope, GameConfig){

                $scope.create = function () {
                    var gameConfig = new GameConfig($scope.game);
                    gameConfig.$save(function(g) {
                        console.log(g);
                    });
                }
        }]);

        controllers.controller("EditGame", ['$scope', '$routeParams', 'GameConfig',
            '$rootScope',
            function($scope, $routeParams,GameConfig, $rootScope) {
                console.log($routeParams.gameId);
                $scope.game = new GameConfig({id:$routeParams.gameId});
                $scope.game.$get();
                $scope.save = function () {
                    var gameConfig = new GameConfig($scope.game);
                    gameConfig.$update(function(g) {
                        console.log(g);
                    });
                };

                $scope.card = {
                    x: 10,
                    y: 10
                };

                $scope.onDrop = function ($data,$event) {
                    console.log($data);
                    console.log($event);

//                    $data.x = $event.tx - $rootScope.desktop.x;
//                    $data.y = $event.ty - $rootScope.desktop.y;
                    console.log('tx '+$event.tx);
//                    console.log('ty'+$event.ty);
                    console.log('desktop.x '+$rootScope.desktop.x);
//                    console.log($rootScope.desktop.y);
//                    $data.x = $event.tx - $rootScope.desktop.x;
//                    $data.y = $event.ty - $rootScope.desktop.y;

                    var rx = $event.tx - $rootScope.desktop.x;
                    var ry = $event.ty - $rootScope.desktop.y;
                    $data.x = rx;
                    $data.y = ry;
                    console.log('rx '+rx);
                    console.log('ry '+ry);
                    $event.element.css('left', rx);
                    $event.element.css('top', ry);
                };


//                var postData = new Posts();
//                postData.id = 123;
//                postData.petName = "Spot";
//                postData.$enter({}, function(data){
//                    $scope.data = data;
//                })
        }]);

        return controllers;

    });