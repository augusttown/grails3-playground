package org.grails.playground

class PublicController {
    def index() {
        render 'Public resource - not secured by Keycloak'
    }
}
