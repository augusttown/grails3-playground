package org.grails.playground

import grails.plugin.springsecurity.annotation.Secured

class SecureController {

    def index() {}

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def home() {
        render 'Secured user access only'
    }
}
