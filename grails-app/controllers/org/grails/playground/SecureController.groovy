package org.grails.playground

import grails.plugin.springsecurity.annotation.Secured

class SecureController {

    @Secured('ROLE_ADMIN')
    def index() {
        render 'Secured admin access only'
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def home() {
        render 'Secured user access only'
    }

}
