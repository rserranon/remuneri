package remuneri

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class NSEServiceSpec extends Specification {

    NSEService NSEService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new NSE(...).save(flush: true, failOnError: true)
        //new NSE(...).save(flush: true, failOnError: true)
        //NSE NSE = new NSE(...).save(flush: true, failOnError: true)
        //new NSE(...).save(flush: true, failOnError: true)
        //new NSE(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //NSE.id
    }

    void "test get"() {
        setupData()

        expect:
        NSEService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<NSE> NSEList = NSEService.list(max: 2, offset: 2)

        then:
        NSEList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        NSEService.count() == 5
    }

    void "test delete"() {
        Long NSEId = setupData()

        expect:
        NSEService.count() == 5

        when:
        NSEService.delete(NSEId)
        sessionFactory.currentSession.flush()

        then:
        NSEService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        NSE NSE = new NSE()
        NSEService.save(NSE)

        then:
        NSE.id != null
    }
}
