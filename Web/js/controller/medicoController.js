angulaAppModulo.controller('MedicoController', function (MedicoService, $scope, $state) {

    var TAMANHO_MINIMO_PESQUISA = 3;
    
    $scope.medicos = [];
    
    $scope.adiciona = function () {
       
        MedicoService.cadastrarMedico($scope.medico)
            .then(function (response) {
            console.log(response.data);
        });
        
    };
    
    
    $scope.pesquisarPacientePorNome = function (nome) {
        
        console.log("Nome: " + nome);
        
        if(nome.length > TAMANHO_MINIMO_PESQUISA) {
            MedicoService.consultarPacientePorNome(nome)
                .then(function (response) {
                    $scope.pacientes = response.data;
                });
        }        
    };
    
    $scope.limparFormulario = function() {
        
        $scope.nome = "";
        angular.copy({}, $scope.pacientes);
        $scope.formPesquisa.$setPristine();
        $scope.formPesquisa.$setValidity();
    };
    
    $scope.listarPacientes = function () {
        MedicoService.listarPacientes()
            .then(function (response) {
                $scope.pacientes = response.data;
            });
    };
    
    
});