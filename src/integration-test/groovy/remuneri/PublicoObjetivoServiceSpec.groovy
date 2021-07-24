package remuneri

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PublicoObjetivoServiceSpec extends Specification {

    PublicoObjetivoService publicoObjetivoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new PublicoObjetivo(...).save(flush: true, failOnError: true)
        //new PublicoObjetivo(...).save(flush: true, failOnError: true)
        //PublicoObjetivo publicoObjetivo = new PublicoObjetivo(...).save(flush: true, failOnError: true)
        //new PublicoObjetivo(...).save(flush: true, failOnError: true)
        //new PublicoObjetivo(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //publicoObjetivo.id
    }

    void "test get"() {
        setupData()

        expect:
        publicoObjetivoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<PublicoObjetivo> publicoObjetivoList = publicoObjetivoService.list(max: 2, offset: 2)

        then:
        publicoObjetivoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        publicoObjetivoService.count() == 5
    }

    void "test delete"() {
        Long publicoObjetivoId = setupData()

        expect:
        publicoObjetivoService.count() == 5

        when:
        publicoObjetivoService.delete(publicoObjetivoId)
        sessionFactory.currentSession.flush()

        then:
        publicoObjetivoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        PublicoObjetivo publicoObjetivo = new PublicoObjetivo()
        publicoObjetivoService.save(publicoObjetivo)

        then:
        publicoObjetivo.id != null
    }
}
