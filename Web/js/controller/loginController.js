angulaAppModulo.controller('loginController', function (LoginService, $scope, $state) {

    $scope.fazerLogin = function () {

        LoginService.fazerLogin($scope.login)
            .then(function (response) {
                console.log(response.data);
            });
    };

});