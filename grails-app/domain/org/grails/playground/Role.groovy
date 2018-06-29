package org.grails.playground

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	private static final long serialVersionUID = 1

	Long id
	String authority
	String createdBy
	Date dateCreated
	String description
	Boolean isActive

	static constraints = {
		authority blank: false, unique: true
	}

	static mapping = {
		//cache true
		table name: 'au_role'
		id column: 'id', generator: 'sequence', params: [sequence: 'role_seq']
	}
}
