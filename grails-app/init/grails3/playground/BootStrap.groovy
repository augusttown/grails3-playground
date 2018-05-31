package grails3.playground

import org.grails.playground.Role
import org.grails.playground.User
import org.grails.playground.UserRole

class BootStrap {

    def init = { servletContext ->

        /*def adminRole = new Role(id: 1, authority: 'ROLE_ADMIN').save()
        def testUser = new User(id: 1, username: 'me', password: 'password').save()

        UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

        assert User.count() == 1
        assert Role.count() == 1
        assert UserRole.count() == 1*/


    }

    def destroy = {
    }
}
