angulaAppModulo.factory("AtualizacaoService", function($http){
    
    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _atualizarDados = function(medico){
        return $http.post(urlBase + "/dadosPessoais", medico)
    };
    
    return{
        atualizarDados: _atualizarDados
    }
    
    
})