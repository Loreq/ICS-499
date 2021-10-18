var linePuzzle= angular.module('linePuzzle', ['ngRoute','gameModule','paintModule']);

linePuzzle.config(['$routeProvider', function($routeProvider) {
    $routeProvider.

        when('/best-score', {
            templateUrl: 'templates/best-score.html',
         //   controller: 'scoreController'
        }).
        when('/game-panel', {
            templateUrl: 'templates/game-panel.html',
            controller: 'gameController',
            controller: 'paintController'

        }).
        otherwise({
            redirectTo: ''
        });
}]);
