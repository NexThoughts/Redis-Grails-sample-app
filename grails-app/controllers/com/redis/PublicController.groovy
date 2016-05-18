package com.redis

class PublicController {

    def redisService

    def ONE_HOUR = 3600

    def index() {

        redisService.foo = "bar"
        assert "bar" == redisService.foo

        println "========redisService.foo======= ${redisService.foo}"
        redisService.sadd("months", "february")
        redisService.sadd("months", "january")
        redisService.sadd("months", "march")
        assert true == redisService.sismember("months", "february")
        println "-----------------" + redisService.sismember("months", "february")
        render "Success"
    }

    def memoize = {
        Long userId = 6
        String output = redisService.memoize("user:$userId") {
            // expensive to calculate method that returns a String
            "Hello Complex : ${calculateSomeComplexData(userId)}"
        }

        render "Output : ${output}"
    }

    def memoizeWithTime = {
        Long userId = 9
        String output = redisService.memoize("user:$userId", [expire: 3600]) {
            // expensive to calculate method that returns a String
            "Hello Complex : ${calculateSomeComplexData(userId)}"
        }
        render "Output : ${output}"
    }

    def memoizeDomain = {

        Long personId = 5
        String key = "person:$personId:favorite"

        println "--"
        println "--"
        println "--"
        println "--"

        Person person = redisService.memoizeDomainObject(Person, key) {
            println "------ Some Complex query to fetch person ------------"
            Person person = Person.findById(personId)
            println "----- Seeing if DB Query is executed -----------"
            return person
        }
        println "************ Memoization Done ****************"

        Person p1 = Person.findById(personId)
        println "---Object---person----------" + person
        println "---ID-------person----------" + person.id
        println "---ID-------p1----------" + p1

        render "Output : ${person}"
    }


    public static String calculateSomeComplexData(Long userId) {
        println "**** Doing some very very very Complex calculation for ${userId}***********"
        return 1000 * userId
    }
}
