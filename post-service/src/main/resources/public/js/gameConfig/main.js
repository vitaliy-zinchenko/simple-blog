require.config({
    paths: {
        angular: '/js/lib/angular',
        angularResource: '/js/lib/angular-resource',
        angularRoute: '/js/lib/angular-route',
        jquery: '/js/lib/jquery-1.11.0.min',
        text: '/js/lib/text',
        css: '/js/lib/css',
        common: '/static/web/js/common',
        underscore: '/underscore'
    },
    baseUrl: '/static/web/js/feedback/site',
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
