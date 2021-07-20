package remuneri

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AnuncioServiceSpec extends Specification {

    AnuncioService anuncioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Anuncio(...).save(flush: true, failOnError: true)
        //new Anuncio(...).save(flush: true, failOnError: true)
        //Anuncio anuncio = new Anuncio(...).save(flush: true, failOnError: true)
        //new Anuncio(...).save(flush: true, failOnError: true)
        //new Anuncio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //anuncio.id
    }

    void "test get"() {
        setupData()

        expect:
        anuncioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Anuncio> anuncioList = anuncioService.list(max: 2, offset: 2)

        then:
        anuncioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        anuncioService.count() == 5
    }

    void "test delete"() {
        Long anuncioId = setupData()

        expect:
        anuncioService.count() == 5

        when:
        anuncioService.delete(anuncioId)
        sessionFactory.currentSession.flush()

        then:
        anuncioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Anuncio anuncio = new Anuncio()
        anuncioService.save(anuncio)

        then:
        anuncio.id != null
    }
}
