// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'com.ch.sso.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'com.ch.sso.UserRole'
grails.plugin.springsecurity.authority.className = 'com.ch.sso.Role'
grails.plugin.springsecurity.oauth2.domainClass = 'com.ch.sso.OAuthID'

//grails.plugin.springsecurity.controllerAnnotations.staticRules = [
//        [pattern: '/',               access: ['permitAll']],
//        [pattern: '/error',          access: ['permitAll']],
//        [pattern: '/index',          access: ['permitAll']],
//        [pattern: '/index.gsp',      access: ['permitAll']],
//        [pattern: '/shutdown',       access: ['permitAll']],
//        [pattern: '/assets/**',      access: ['permitAll']],
//        [pattern: '/**/js/**',       access: ['permitAll']],
//        [pattern: '/**/css/**',      access: ['permitAll']],
//        [pattern: '/**/images/**',   access: ['permitAll']],
//        [pattern: '/**/favicon.ico', access: ['permitAll']]
//]
//
//grails.plugin.springsecurity.filterChain.chainMap = [
//        [pattern: '/assets/**',      filters: 'none'],
//        [pattern: '/**/js/**',       filters: 'none'],
//        [pattern: '/**/css/**',      filters: 'none'],
//        [pattern: '/**/images/**',   filters: 'none'],
//        [pattern: '/**/favicon.ico', filters: 'none'],
//        [pattern: '/**',             filters: 'JOINED_FILTERS']
//]

grails.plugin.springsecurity.logout.postOnly = false

grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = false

// secure resources
grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/',                  access: ['ROLE_USER','ROLE_ADMIN']],
        [pattern: '/secure',            access: ['ROLE_USER','ROLE_ADMIN']],
        [pattern: '/secure/**',         access: ['ROLE_USER','ROLE_ADMIN']],
        [pattern: '/user',              access: ['ROLE_ADMIN']],
        [pattern: '/user/**',           access: ['ROLE_ADMIN']],
        [pattern: '/auth/**',           access: ['ROLE_USER','ROLE_ADMIN']],
        [pattern: '/error',             access: ['permitAll']],
        [pattern: '/index',             access: ['permitAll']],
        [pattern: '/index.gsp',         access: ['permitAll']],
        [pattern: '/shutdown',          access: ['permitAll']],
        [pattern: '/assets/**',         access: ['permitAll']],
        [pattern: '/**/js/**',          access: ['permitAll']],
        [pattern: '/**/css/**',         access: ['permitAll']],
        [pattern: '/**/images/**',      access: ['permitAll']],
        [pattern: '/**/favicon.ico',    access: ['permitAll']],
        [pattern: '/login',             access: ['permitAll']],
        [pattern: '/login/**',          access: ['permitAll']],
        [pattern: '/logout',            access: ['permitAll']],
        [pattern: '/logout/**',         access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**',         filters: 'none'],
        [pattern: '/**/js/**',          filters: 'none'],
        [pattern: '/**/css/**',         filters: 'none'],
        [pattern: '/**/images/**',      filters: 'none'],
        [pattern: '/**/favicon.ico',    filters: 'none'],
        [pattern: '/**',                filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.providerNames = ['daoAuthenticationProvider', 'anonymousAuthenticationProvider']

security {
    oauth2 {
        providers {
            keycloak {
                successUri = "/oauth2/keycloak/success"
                failureUri = "/oauth2/keycloak/failure"
                callback = "/oauth2/keycloak/callback"
                api_key = "grails3-playground"                          // keycloak client id
                api_secret = "be6061d3-a0c5-4082-97fe-2f014c38de2b"     // keycloak client secret
            }
        }
    }
}