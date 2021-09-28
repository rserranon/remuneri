package remuneri

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ContenidoServiceSpec extends Specification {

    ContenidoService contenidoService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Contenido(...).save(flush: true, failOnError: true)
        //new Contenido(...).save(flush: true, failOnError: true)
        //Contenido contenido = new Contenido(...).save(flush: true, failOnError: true)
        //new Contenido(...).save(flush: true, failOnError: true)
        //new Contenido(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //contenido.id
    }

    void "test get"() {
        setupData()

        expect:
        contenidoService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Contenido> contenidoList = contenidoService.list(max: 2, offset: 2)

        then:
        contenidoList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        contenidoService.count() == 5
    }

    void "test delete"() {
        Long contenidoId = setupData()

        expect:
        contenidoService.count() == 5

        when:
        contenidoService.delete(contenidoId)
        sessionFactory.currentSession.flush()

        then:
        contenidoService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Contenido contenido = new Contenido()
        contenidoService.save(contenido)

        then:
        contenido.id != null
    }
}
