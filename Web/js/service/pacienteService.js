angulaAppModulo.factory("PacienteService", function($http) {

    // Servidor REST disponível na aplicação RestEasyApp.
    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _cadastrarPaciente = function(paciente){
		return $http.post(urlBase + "/medico/cadastroPaciente", paciente)
	};

    // Separar os serviços disponíveis por uma vírgula (,).
    return {
        cadastrarPaciente: _cadastrarPaciente
    };
});