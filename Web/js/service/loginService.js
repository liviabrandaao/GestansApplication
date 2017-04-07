angulaAppModulo.factory("LoginService", function($http) {

    var urlBase = "http://localhost:8080/Web";
    
    var _fazerLogin = function(login){
		return $http.post(urlBase + "/medico/login", login)
	};

    return {
        fazerLogin: _fazerLogin
    };
});