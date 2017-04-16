angulaAppModulo.controller('PacienteController', function (PacienteService, $scope, $state) {

    $scope.pacientes = [];
    
    $scope.autoavaliacao = {};
    
    $scope.autoavaliacao.dorMuscular = false;

    $scope.adicionaPaciente = function () {

        PacienteService.cadastrarPaciente($scope.paciente)
            .then(function (response) {
                console.log(response.data); 
            });
    };
    
    
      $scope.niveis = ['Nível 0','Nível 1','Nível 2' ,'Nível 3' ,'Nível 4' ,'Nível 5', 'Nível 6', 'Nível 7', 'Nível 8', 'Nível 9', 'Nível 10'];
      $scope.febre = ['Não','Alta (acima de 38º)' ,'Baixo (abaixo de 38º)'];
      $scope.sangramento = ['Não','Sim'];
      $scope.faltaAr = ['Não','Sim'];
      $scope.cansaco = ['Não','Sim'];
      $scope.tosse = ['Não','Sim'];
      $scope.dorGarganta = ['Não','Sim'];
      $scope.dormenciaPerna = ['Não','Sim'];
      $scope.dormenciaBraco = ['Não','Sim'];
      $scope.cefaleia = ['Não','Sim'];
      $scope.pressao = ['Não','Sim'];
      $scope.tontura = ['Não','Sim'];
      $scope.desmaio = ['Não','Sim'];
    
});