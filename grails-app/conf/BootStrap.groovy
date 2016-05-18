import com.redis.*

class BootStrap {

    def init = { servletContext ->
        bootstrapPersons()

    }
    def destroy = {

    }

    void bootstrapPersons() {
        (1..100).each { Integer personIndex ->
            com.redis.Person person = new com.redis.Person()
            person.name = "Person-${personIndex}"
            person.age = personIndex + 10
            person.save(flush: true)
            println "**** Saved Person ${personIndex}"

            (1..3).each { Integer addressIndex ->
                Address address = new Address()
                address.locality = "Locality ${addressIndex} for Person ${personIndex}"
                address.country = "Country ${personIndex}"
                address.person = person
                person.addToAddresses(address)
                address.save(flush: true)
                println "**** Saved Address ${addressIndex} for Person ${personIndex}"
            }
        }
    }
}
