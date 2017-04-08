angulaAppModulo.factory("LoginService", function($http) {

    // Servidor REST disponível na aplicação RestEasyApp.
    var urlBase = "http://localhost:8080/RestEasyApp";
    
    var _fazerLogin = function(login){
		return $http.post(urlBase + "/medico/login", login)
	};

    // Separar os serviços disponíveis por uma vírgula (,).
    return {
        fazerLogin: _fazerLogin
    };
});