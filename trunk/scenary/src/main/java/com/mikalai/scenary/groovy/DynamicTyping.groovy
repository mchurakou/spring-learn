package com.mikalai.scenary.groovy

class Contact {
    def firstName
    def lastName
    def birthDate
    String toString() { "($firstName, $lastName, $birthDate)"}

}

Contact contact = new Contact(firstName: 'Clarence', lastName: 'Ho', birthDate: new Date())
Contact anotherContact = new Contact(firstName: 10, lastName: 'Ho1', birthDate: new Date())

println contact
println anotherContact

println contact.firstName + 20
println anotherContact.firstName + 20

