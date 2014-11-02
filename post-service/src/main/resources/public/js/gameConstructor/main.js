require.config({
    paths: {
        angular: '/js/libs/angular',
        angularResource: '/js/libs/angular-resource',
        angularRoute: '/js/libs/angular-route',
        angularDraggable: '/js/libs/ngDraggable',
        jquery: '/js/libs/jquery-1.11.0.min',
        text: '/js/libs/text',
        css: '/js/libs/css',
        common: '/js/common',
        underscore: 'js/libs/underscore'
    },
    baseUrl: '/js/gameConstructor',
    shim: {
        angular: {'exports': 'angular'},
        angularResource: {
            deps: ['angular']
        },
        angularRoute: {
            deps: ['angular']
        },
        angularCarousel: {
            deps: ['angular']
        },
        angularTouch: {
            deps: ['angular']
        }
    },
    priority: [
        "angular"
    ]
});
