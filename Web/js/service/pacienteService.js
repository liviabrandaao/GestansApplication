angulaAppModulo.factory("PacienteService", function($http) {

    var urlBase = "http://localhost:8080/GestansApplication";
    
    var _cadastrarPaciente = function(paciente){
		return $http.post(urlBase + "/medico/cadastroPaciente", paciente)
	};

    return {
        cadastrarPaciente: _cadastrarPaciente
    };
});