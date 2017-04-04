angulaAppModulo.factory("LoginService", function($http) {

    var urlBase = "http://localhost:8080/GestansApplication";
    
    var _efetuarLogin = function(login){
		return $http.post(urlBase + "/medico/login", login)
	};

    return {
        fazerLogin: _fazerLogin
    };
});