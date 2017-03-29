angulaAppModulo.controller('medicoController', function (MedicoService, $scope) {

    $scope.medicos = [];
    
    $scope.adiciona = function(medico){
       $scope.medicos.push(angular.copy(medicos)); 
    }
});