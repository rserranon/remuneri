package remuneri

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class InteresServiceSpec extends Specification {

    InteresService interesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Interes(...).save(flush: true, failOnError: true)
        //new Interes(...).save(flush: true, failOnError: true)
        //Interes interes = new Interes(...).save(flush: true, failOnError: true)
        //new Interes(...).save(flush: true, failOnError: true)
        //new Interes(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //interes.id
    }

    void "test get"() {
        setupData()

        expect:
        interesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Interes> interesList = interesService.list(max: 2, offset: 2)

        then:
        interesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        interesService.count() == 5
    }

    void "test delete"() {
        Long interesId = setupData()

        expect:
        interesService.count() == 5

        when:
        interesService.delete(interesId)
        sessionFactory.currentSession.flush()

        then:
        interesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Interes interes = new Interes()
        interesService.save(interes)

        then:
        interes.id != null
    }
}
