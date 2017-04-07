(function() {
  'use strict';

  angular.module('navBarDemoBasicUsage', ['ngMaterial'])
      .controller('MenuController', Web);

  function Menu($scope) {
    $scope.currentNavItem = 'home';
  }
    
})();