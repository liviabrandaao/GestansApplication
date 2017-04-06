angulaAppModulo.factory("MedicoService", function($http) {

    var urlBase = "http://localhost:8080/GestansApplication";
    
    var _cadastrarMedico = function(medico){
		return $http.post(urlBase + "/medico/cadastro", medico)
	};

    return {
        cadastrarMedico: _cadastrarMedico
    };
});