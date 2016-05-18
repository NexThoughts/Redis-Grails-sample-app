package com.redis

class DemoTagLib {
    static defaultEncodeAs = [taglib: 'html']


    def redisService

    static namespace = 'demo'

    def personRecord = { attrs, body ->
        println "---- Doing some very complex calcualtions to get the output of this tag ------------"
        println "--- QUERIES-----"
        println "--- QUERIES-----"
        println "--- QUERIES-----"
        println "--- QUERIES-----"
        List<Person> personList = Person.findAllByIdInList([1, 2, 45, 4, 5, 6, 7, 8, 9, 10])

        out << g.render(template: '/public/personTemplate', model: [personList: personList])
    }
}
