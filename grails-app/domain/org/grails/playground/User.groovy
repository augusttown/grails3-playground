package org.grails.playground

import grails.plugin.springsecurity.SpringSecurityService
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

	private static final long serialVersionUID = 1

	SpringSecurityService springSecurityService

	String username
	String password
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	Date passwordLastUpdated

	String createdBy
	Date dateCreated
	String updatedBy
	Date dateUpdated

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

	static transients = ['springSecurityService']

	static constraints = {
		password blank: false, password: true
		username blank: false, unique: true
		createdBy nullable: true
		dateCreated nullable: true
		updatedBy nullable: true
		dateUpdated nullable: true
		passwordLastUpdated nullable: true
	}

	static mapping = {
		table name: 'au_user'
		id column: 'id', generator: 'sequence', params: [sequence: 'user_seq']
		password column: 'password'
	}
}
