angulaAppModulo.factory("AutoAvaliacaoService", function($http){
    
    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _enviarDados = function(autoavaliacao){
        return $http.post(urlBase + "/autoAvaliacao", autoavaliacao)
    };
    
    return{
        enviarDados: _enviarDados
    }
    
    
})