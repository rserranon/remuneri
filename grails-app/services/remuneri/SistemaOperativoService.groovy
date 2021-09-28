package remuneri

import grails.gorm.services.Service

@Service(SistemaOperativo)
interface SistemaOperativoService {

    SistemaOperativo get(Serializable id)

    List<SistemaOperativo> list(Map args)

    Long count()

    void delete(Serializable id)

    SistemaOperativo save(SistemaOperativo sistemaOperativo)

}