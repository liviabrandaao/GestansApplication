angulaAppModulo.config(function ($stateProvider, $urlRouterProvider) {
    
    // Rota padrão.
    $urlRouterProvider.otherwise("/");
    
    // Estados
    $stateProvider
        .state("medico/cadastrar", {
            url: "/medico/cadastrar",
            templateUrl: "cadastrarMedico.html"
        })
        .state("paciente/cadastrar", {
            url: "/paciente/cadastrar",
            templateUrl: "cadastrarPaciente.html"
        })
        .state("loginMedico", {
            url: "/loginMedico",
            templateUrl: "loginMedico.html"
        })
        .state("home", {
            url: "/",
            templateUrl: "home.html"
        })
        .state("paciente/autoavaliacao", {
            url: "/paciente/autoavaliacao",
            templateUrl: "autoavaliacao.html"
        })
        .state("loginPaciente", {
            url: "/loginPaciente",
            templateUrl: "loginPaciente.html"
        })
        .state("homeMedico", {
            url: "/homeMedico",
            templateUrl: "homeMedico.html"
        })
        .state("homePaciente", {
            url: "/homePaciente",
            templateUrl: "homePaciente.html"
        })
        .state("pesquisarPaciente", {
            url: "/medico/pesquisar",
            templateUrl: "pesquisarPaciente.html"
        })
});