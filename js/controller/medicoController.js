angulaAppModulo.controller('medicoController', function (MedicoService, $scope) {

    $scope.medicos = [];
    
    $scope.adiciona = function () {
       
        MedicoService.cadastrarMedico($scope.medico)
            .then(function (response) {
            console.log(response.data);
        });
        
    };
    
});