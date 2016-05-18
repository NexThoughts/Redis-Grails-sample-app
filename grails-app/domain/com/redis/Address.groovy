package com.redis

class Address {

    String locality
    String country


    static belongsTo = [person: Person]

    static constraints = {

    }

}
