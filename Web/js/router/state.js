angulaAppModulo.config(function ($stateProvider, $urlRouterProvider) {
    
    // Rota padrão.
    $urlRouterProvider.otherwise("/");
    
    // Estados
    $stateProvider
        .state('cadastrar', {
            url: '/cadastrar',
            templateUrl: 'cadastrar.html'
        })
        .state('cadastraPaciente', {
            url: '/cadastrarPaciente',
            templateUrl: 'cadastrarPaciente.html'
        })
});