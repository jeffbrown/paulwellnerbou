package paulwellnerbou

import grails.test.hibernate.HibernateSpec
import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class HelperServiceSpec extends HibernateSpec implements ServiceUnitTest<HelperService>{

    @Override
    List<Class> getDomainClasses() {
        [Person]
    }

    def 'test some db interactin'() {

        when:
        Person.saveAll(
                new Person(firstName: 'Keith', lastName: 'Emerson'),
                new Person(firstName: 'Greg', lastName: 'Lake'),
                new Person(firstName: 'Carl', lastName: 'Palmer'),
        )

        then:
        service.retrievePeople().size() == 3
        service.dbUrl == 'jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE'
    }
}
