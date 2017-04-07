angulaAppModulo.controller('pacienteController', function (PacienteService, $scope, $state) {

    $scope.pacientes = [];

    $scope.adicionaPaciente = function () {

        PacienteService.cadastrarPaciente($scope.paciente)
            .then(function (response) {
                console.log(response.data);
            });
    };

});