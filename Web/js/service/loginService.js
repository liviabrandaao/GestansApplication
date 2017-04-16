angulaAppModulo.factory("LoginService", function($http) {

    // Servidor REST disponível na aplicação RestEasyApp.
    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _fazerLoginMedico = function(medico){
		return $http.post(urlBase + "/loginMedico", medico)
	};
    
    var _fazerLoginPaciente = function(loginPaciente){
        return $http.post(urlBase + "/loginPaciente", loginPaciente)
    }

    // Separar os serviços disponíveis por uma vírgula (,).
    return {
        fazerLoginMedico: _fazerLoginMedico,
        fazerLoginPaciente: _fazerLoginPaciente
    };
});