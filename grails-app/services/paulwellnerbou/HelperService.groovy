package paulwellnerbou

import grails.gorm.transactions.Transactional
import org.springframework.beans.factory.annotation.Value

class HelperService {

    @Value('${dataSource.url}')
    String dbUrl

    @Transactional(readOnly = true)
    List<Person> retrievePeople() {
        Person.list()
    }
}
