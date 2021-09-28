package remuneri

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class SistemaOperativoServiceSpec extends Specification {

    SistemaOperativoService sistemaOperativoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new SistemaOperativo(...).save(flush: true, failOnError: true)
        //new SistemaOperativo(...).save(flush: true, failOnError: true)
        //SistemaOperativo sistemaOperativo = new SistemaOperativo(...).save(flush: true, failOnError: true)
        //new SistemaOperativo(...).save(flush: true, failOnError: true)
        //new SistemaOperativo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //sistemaOperativo.id
    }

    void "test get"() {
        setupData()

        expect:
        sistemaOperativoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<SistemaOperativo> sistemaOperativoList = sistemaOperativoService.list(max: 2, offset: 2)

        then:
        sistemaOperativoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        sistemaOperativoService.count() == 5
    }

    void "test delete"() {
        Long sistemaOperativoId = setupData()

        expect:
        sistemaOperativoService.count() == 5

        when:
        sistemaOperativoService.delete(sistemaOperativoId)
        sessionFactory.currentSession.flush()

        then:
        sistemaOperativoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        SistemaOperativo sistemaOperativo = new SistemaOperativo()
        sistemaOperativoService.save(sistemaOperativo)

        then:
        sistemaOperativo.id != null
    }
}
