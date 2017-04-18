angulaAppModulo.controller('AtualizacaoController', function (AtualizacaoService, $scope, $state){
    
    
    $scope.atualizar = function (){
        
        AtualizacaoService.atualizarDados($scope.medico)
            .then(function (response){
            console.log(response.data);
        });   
    }    
})