package remuneri

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MovimientoAnuncioServiceSpec extends Specification {

    MovimientoAnuncioService movimientoAnuncioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MovimientoAnuncio(...).save(flush: true, failOnError: true)
        //new MovimientoAnuncio(...).save(flush: true, failOnError: true)
        //MovimientoAnuncio movimientoAnuncio = new MovimientoAnuncio(...).save(flush: true, failOnError: true)
        //new MovimientoAnuncio(...).save(flush: true, failOnError: true)
        //new MovimientoAnuncio(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //movimientoAnuncio.id
    }

    void "test get"() {
        setupData()

        expect:
        movimientoAnuncioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MovimientoAnuncio> movimientoAnuncioList = movimientoAnuncioService.list(max: 2, offset: 2)

        then:
        movimientoAnuncioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        movimientoAnuncioService.count() == 5
    }

    void "test delete"() {
        Long movimientoAnuncioId = setupData()

        expect:
        movimientoAnuncioService.count() == 5

        when:
        movimientoAnuncioService.delete(movimientoAnuncioId)
        sessionFactory.currentSession.flush()

        then:
        movimientoAnuncioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MovimientoAnuncio movimientoAnuncio = new MovimientoAnuncio()
        movimientoAnuncioService.save(movimientoAnuncio)

        then:
        movimientoAnuncio.id != null
    }
}
