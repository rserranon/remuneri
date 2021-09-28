package remuneri

import grails.gorm.services.Service

@Service(Contenido)
interface ContenidoService {

    Contenido get(Serializable id)

    List<Contenido> list(Map args)

    Long count()

    void delete(Serializable id)

    Contenido save(Contenido contenido)

}