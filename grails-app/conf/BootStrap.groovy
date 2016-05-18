import com.redis.*

class BootStrap {

    def init = { servletContext ->
        bootstrapPersons()

    }
    def destroy = {

    }

    void bootstrapPersons() {
        (0..100).each {
            com.redis.Person person = new com.redis.Person()
            person.name = "Person-${it}"
            person.age = it + 10
            person.save(flush: true)
            println "**** Saved Person ${it}"
        }
    }

}
