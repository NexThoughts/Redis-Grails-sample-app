package com.redis

class Person {

    String name
    Long age

    List<Address> addressList = []

    static hasMany = [addresses: Address]


    static constraints = {

    }

}
