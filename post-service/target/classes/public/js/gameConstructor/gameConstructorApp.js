define(['angular', 'angularRoute', 'common/services',
        'text!common/tmpl/notification.html',
        'controllers', 'text!tmpl/gameList.html',
        'text!tmpl/createGame.html', 'text!tmpl/editGame.html',
        'css!/css/bootstrap.min.css', 'css!/css/game-constructor.css',
        'css!/css/common.css'],
    function(ng, ngRoute, commonServices,
             notification,
             controllers, gameListTmpl,
             createGameTmpl, editGameTmpl,
             bootstrapCSS, gameConstructorCSS, commonCSS) {

    var feedbackApp = angular.module('GameConstructorApp',
        ['ngRoute', 'commonServices', 'gameConstructorControllers']);

    feedbackApp.config(['$httpProvider', 'notificationServiceProvider',
        function($httpProvider, notificationServiceProvider) {
            $httpProvider.interceptors.push('errorListenerService');
            notificationServiceProvider.setNotificationTmpl(notification);
    }]);

    feedbackApp.config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/', {
            template : gameListTmpl,
            controller : 'GameList'
        }).when('/createGame', {
            template : createGameTmpl,
            controller : 'CreateGame'
        }).when('/editGame/:gameId', {
            template : editGameTmpl,
            controller : 'EditGame'
        }).otherwise({
            'redirectTo' : '/'
        });
    }]);

    return feedbackApp;
});
