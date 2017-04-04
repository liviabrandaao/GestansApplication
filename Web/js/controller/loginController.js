angulaAppModulo.controller('loginController', function (LoginService, $scope, $state) {

    
    $scope.fazerLogin = function () {
       
        LoginService.efetuarLogin($scope.login)
            .then(function (response) {
            console.log(response.data);
        });
        
    };
    
});