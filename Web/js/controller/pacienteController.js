angulaAppModulo.controller('PacienteController', function (PacienteService, $scope, $state) {

    $scope.pacientes = [];

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
      $scope.tonturas = ['Não','Sim'];
      $scope.desmaios = ['Não','Sim'];
      $scope.dorMuscular;
      
    
      
      console.log($scope.febre);
      $scope.getFebre = function() {
        if ($scope.febre !== undefined) {
          return $scope.febre;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.sangramento);
      $scope.getSangramento = function() {
        if ($scope.sangramento !== undefined) {
          return $scope.sangramento;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.faltaAr);
      $scope.getFaltaAr = function() {
        if ($scope.faltaAr !== undefined) {
          return $scope.faltaAr;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.cansaco);
      $scope.getCansaco = function() {
        if ($scope.cansaco !== undefined) {
          return $scope.cansaco;
        } else {
          return "Selecione um item";
        }
      };

    console.log($scope.tosse);
      $scope.getTosse = function() {
        if ($scope.tosse !== undefined) {
          return $scope.tosse;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.dorGarganta);
      $scope.getDorGarganta = function() {
        if ($scope.dorGarganta !== undefined) {
          return $scope.dorGarganta;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.dormenciaPerna);
      $scope.getDormenciaPerna = function() {
        if ($scope.dormenciaPerna !== undefined) {
          return $scope.dormenciaPerna;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.dormenciaBraco);
      $scope.getDormenciaBraco = function() {
        if ($scope.dormenciaBraco !== undefined) {
          return $scope.dormenciaBraco;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.cefaleia);
      $scope.getCefaleia = function() {
        if ($scope.cefaleia !== undefined) {
          return $scope.cefaleia;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.pressao);
      $scope.getPressao = function() {
        if ($scope.pressao !== undefined) {
          return $scope.pressao;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.tonturas);
      $scope.getTonturas = function() {
        if ($scope.tonturas !== undefined) {
          return $scope.tonturas;
        } else {
          return "Selecione um item";
        }
      };
    
    console.log($scope.desmaios);
      $scope.getDesmaios = function() {
        if ($scope.desmaios !== undefined) {
          return $scope.desmaios;
        } else {
          return "Selecione um item";
        }
      };
    
});