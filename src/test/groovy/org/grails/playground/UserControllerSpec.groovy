package org.grails.playground

import grails.test.mixin.*
import spock.lang.*

@TestFor(UserController)
@Mock(User)
class UserControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test something"() {
        expect:"fix me"
        true == true
    }
}
