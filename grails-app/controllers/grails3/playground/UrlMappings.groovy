package grails3.playground

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "/login/auth"(redirect: "/springSecurityOAuth2/authenticate?provider=keycloak") // redirect spring security login/auth to keycloak login page
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
