<div class="content">
    <nav class="navbar navbar-default" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Конструктор игр</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#/createGame">Создать игру</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="game-constructor-content" id="gameConstructor">
        <div ng-view></div>
    </div>
</div>

<link type="text/css" rel="stylesheet" href="/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="/css/common.css">
<link type="text/css" rel="stylesheet" href="/css/game-constructor.css">

<script src="/js/libs/require.js"></script>
<script>
    require(['/js/gameConstructor/main.js'], function(main) {
        require(['angular', 'gameConstructorApp', 'jquery'],
                function(angular, gameConstructorApp, $) {
                    var $html = angular.element($('#gameConstructor')[0]);

                    angular.element().ready(function () {
                        angular.bootstrap($html, [gameConstructorApp['name']]);
                    });
        });
    })
</script>

