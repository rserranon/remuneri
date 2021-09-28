package remuneri

import grails.gorm.services.Service

@Service(MovimientoUsuario)
interface MovimientoUsuarioService {

    MovimientoUsuario get(Serializable id)

    List<MovimientoUsuario> list(Map args)

    Long count()

    void delete(Serializable id)

    MovimientoUsuario save(MovimientoUsuario movimientoUsuario)

}