angulaAppModulo.config(function ($stateProvider, $urlRouterProvider) {
    
    // Rota padrão.
    $urlRouterProvider.otherwise("/");
    
    // Estados
    $stateProvider
        .state("index", {
            url: "index",
            templateUrl: "index.html"
        })
        .state("medico/cadastrar", {
            url: "/medico/cadastrar",
            templateUrl: "cadastrarMedico.html"
        })
        .state("paciente/cadastrar", {
            url: "/paciente/cadastrar",
            templateUrl: "cadastrarPaciente.html"
        })
        .state("medico/login", {
            url: "/medico/login",
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
        .state("paciente/login", {
            url: "paciente/login",
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
        .state("homeCadastroMedico", {
            url: "/homeCadastroMedico",
            templateUrl: "homeCadastroMedico.html"
        })
        .state("homeCadastroPaciente", {
            url: "/homeCadastroPaciente",
            templateUrl: "homeCadastroPaciente.html"
        })
        .state("homeCMP", {
            url: "/homeCMP",
            templateUrl: "homeCMP.html"
        })
    
        .state("dadosPessoaisM", {
            url:"/dadosPessoaisM",
        templateUrl: "dadosPessoaisM.html"
        })
});