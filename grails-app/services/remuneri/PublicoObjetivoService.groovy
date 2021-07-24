package remuneri

import grails.gorm.services.Service

@Service(PublicoObjetivo)
interface PublicoObjetivoService {

    PublicoObjetivo get(Serializable id)

    List<PublicoObjetivo> list(Map args)

    Long count()

    void delete(Serializable id)

    PublicoObjetivo save(PublicoObjetivo publicoObjetivo)

}