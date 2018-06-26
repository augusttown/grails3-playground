// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'org.grails.playground.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'org.grails.playground.UserRole'
grails.plugin.springsecurity.authority.className = 'org.grails.playground.Role'

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

grails.plugin.springsecurity.oauth2.active = true

grails.plugin.springsecurity.oauth2.domainClass = 'org.grails.playground.OAuthID'
grails.plugin.springsecurity.securityConfigType = 'InterceptUrlMap'
grails.plugin.springsecurity.rejectIfNoRule = false
grails.plugin.springsecurity.fii.rejectPublicInvocations = false

grails.plugin.springsecurity.interceptUrlMap = [
        [pattern: '/', access: ['ROLE_USER','ROLE_ADMIN']],
        //[pattern: '/', access: ['permitAll']],
        [pattern: '/auth/**', access: ['ROLE_USER','ROLE_ADMIN']],
        //[pattern: '/auth/**', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
        [pattern: '/login', access: ['permitAll']],
        [pattern: '/login/**', access: ['permitAll']],
        [pattern: '/logout', access: ['permitAll']],
        [pattern: '/logout/**', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [pattern: '/**', filters: 'JOINED_FILTERS']
]

grails.plugin.springsecurity.providerNames = ['daoAuthenticationProvider', 'anonymousAuthenticationProvider']

security {
    oauth2 {
        providers {
            keycloak {
                successUri = "/oauth2/keycloak/success"
                failureUri = "/oauth2/keycloak/failure"
                callback = "/oauth2/keycloak/callback"
                api_key = "grails3-playground"
                api_secret = "da60dba3-c26e-43fb-a2b5-495b91eab039"
            }
        }
    }
}