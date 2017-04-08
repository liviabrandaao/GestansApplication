angulaAppModulo.factory("MedicoService", function($http) {

    var urlBase = "http://localhost:8080/Web";
    
    var _cadastrarMedico = function(medico){
		return $http.post(urlBase + "/medico/cadastro", medico)
	};

    var _consultarPacientePorNome = function(nome){
		return $http.get(urlBase + "/medico/pesquisar/nome/" + encodeURI(nome))
	};
    
    return {
        cadastrarMedico: _cadastrarMedico
        consultarPacientePorNome: _consultarPacientePorNome
    };
    
    
});