angulaAppModulo.config(function ($stateProvider, $urlRouterProvider) {
    
    // Rota padrão.
    $urlRouterProvider.otherwise("/");
    
    // Estados
    $stateProvider
        .state('medico.cadastrar', {
            url: '/medico/cadastrar',
            templateUrl: 'cadastrarMedico.html'
        })
        .state('paciente.cadastrar', {
            url: '/paciente/cadastrar',
            templateUrl: 'cadastrarPaciente.html'
        })
});