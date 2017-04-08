(function() {
  'use strict';

  angular.module('navBarDemoBasicUsage', ['ngMaterial'])
      .controller('MenuController');

  function Menu($scope) {
    $scope.currentNavItem = 'home';
  }
    
})();