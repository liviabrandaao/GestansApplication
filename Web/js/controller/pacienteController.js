angulaAppModulo.controller(pacienteController', function (PacienteService, $scope, $state) {

    $scope.pacientes = [];
    
    $scope.adiciona = function () {
       
        PacienteService.cadastrarPaciente($scope.paciente)
            .then(function (response) {
            console.log(response.data);
        });
        
    };
    
});