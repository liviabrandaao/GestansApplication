angulaAppModulo.factory("MedicoService", function($http) {

    // Servidor REST disponível na aplicação RestEasyApp.
    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _cadastrarMedico = function(medico){
		return $http.post(urlBase + "/medico/cadastro", medico)
	};

    var _consultarPacientePorNome = function(nome){
		return $http.get(urlBase + "/medico/pesquisar/nome/" + encodeURI(nome))
	};
    
    // Separar os serviços disponíveis por uma vírgula (,).
    return {
        cadastrarMedico: _cadastrarMedico,
        consultarPacientePorNome: _consultarPacientePorNome
    };    
});