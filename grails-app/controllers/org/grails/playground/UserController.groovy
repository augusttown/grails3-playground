package org.grails.playground

import grails.transaction.Transactional

@Transactional(readOnly = true)
class UserController {

    //static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond User.list(params), model:[userCount: User.count()]
    }
}
