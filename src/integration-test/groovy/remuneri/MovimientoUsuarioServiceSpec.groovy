package remuneri

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MovimientoUsuarioServiceSpec extends Specification {

    MovimientoUsuarioService movimientoUsuarioService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new MovimientoUsuario(...).save(flush: true, failOnError: true)
        //new MovimientoUsuario(...).save(flush: true, failOnError: true)
        //MovimientoUsuario movimientoUsuario = new MovimientoUsuario(...).save(flush: true, failOnError: true)
        //new MovimientoUsuario(...).save(flush: true, failOnError: true)
        //new MovimientoUsuario(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //movimientoUsuario.id
    }

    void "test get"() {
        setupData()

        expect:
        movimientoUsuarioService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<MovimientoUsuario> movimientoUsuarioList = movimientoUsuarioService.list(max: 2, offset: 2)

        then:
        movimientoUsuarioList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        movimientoUsuarioService.count() == 5
    }

    void "test delete"() {
        Long movimientoUsuarioId = setupData()

        expect:
        movimientoUsuarioService.count() == 5

        when:
        movimientoUsuarioService.delete(movimientoUsuarioId)
        sessionFactory.currentSession.flush()

        then:
        movimientoUsuarioService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        MovimientoUsuario movimientoUsuario = new MovimientoUsuario()
        movimientoUsuarioService.save(movimientoUsuario)

        then:
        movimientoUsuario.id != null
    }
}
