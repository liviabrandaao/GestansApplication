angulaAppModulo.controller('LoginController', function (LoginService, $scope, $state) {

    $scope.fazerLoginMedico = function () {

        $scope.medico = [];
        
        LoginService.fazerLoginMedico($scope.login)
            .then(function (response) {
                console.log(response.data);
            
                $scope.medico = response.data;
            
                $state.go('homeMedico');
            });
    };
    
    
    $scope.fazerLoginPaciente = function () {

        LoginService.fazerLoginPaciente($scope.login)
            .then(function (response) {
                console.log(response.data);
                $state.go('homePaciente');
            });
    };
    
    $scope.$go = function(path){
          $location.path(path);
    }

});