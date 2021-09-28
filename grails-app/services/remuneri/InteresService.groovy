package remuneri

import grails.gorm.services.Service

@Service(Interes)
interface InteresService {

    Interes get(Serializable id)

    List<Interes> list(Map args)

    Long count()

    void delete(Serializable id)

    Interes save(Interes interes)

}