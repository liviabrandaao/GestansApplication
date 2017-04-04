angulaAppModulo.controller('medicoController', function (MedicoService, $scope, $state) {

    $scope.medicos = [];
    
    $scope.adiciona = function () {
       
        MedicoService.cadastrarMedico($scope.medico)
            .then(function (response) {
            console.log(response.data);
        });
        
    };
    
});