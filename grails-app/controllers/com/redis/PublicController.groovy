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


    public static String calculateSomeComplexData(Long userId) {
        println "**** Doing some very very very Complex calculation for ${userId}***********"
        return 1000 * userId
    }
}
