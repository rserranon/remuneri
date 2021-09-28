package remuneri

import grails.gorm.services.Service

@Service(MovimientoAnuncio)
interface MovimientoAnuncioService {

    MovimientoAnuncio get(Serializable id)

    List<MovimientoAnuncio> list(Map args)

    Long count()

    void delete(Serializable id)

    MovimientoAnuncio save(MovimientoAnuncio movimientoAnuncio)

}