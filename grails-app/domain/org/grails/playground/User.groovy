package org.grails.playground

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	transient springSecurityService
	transient securityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    private Set<UserRole> userRole = new HashSet<UserRole>(0);
    static hasMany = [oAuthIDs: OAuthID]

    static transients = ['springSecurityService', 'securityService']

	Set<Role> getAuthorities() {
		(UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
	}

	static mapping = {
		table name: 'au_user'
		id column: 'id'//, generator: 'sequence', params: [sequence: 'user_seq']
		password column: 'password'
	}

    boolean isAdmin() {
        return securityService.hasRole(Role.ROLE_ADMIN)
    }

    boolean hasRole(String role) {
        return securityService.hasRole(role)
    }

    def isUniqueName() {
        if (this.id != null)
            return !User.findAllByUsernameIlikeAndIdNotEqual(this.username, this.id);
        else
            return !User.findAllByUsernameIlike(this.username);
    }
}
