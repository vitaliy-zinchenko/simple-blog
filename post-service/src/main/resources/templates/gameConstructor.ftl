<div id="feedbackApp">
    <div ng-view></div>
</div>

<script src="/static/requirejs/require.js"></script>
<script>
    require(['/js/gameConfig/main.js'], function(main) {
        require(['angular', 'app', 'jquery'], function(angular, app, $) {
            var $html = angular.element($('#feedbackApp')[0]);

            angular.element().ready(function () {
                angular.bootstrap($html, [app['name']]);
            });
        });
    })
</script>

