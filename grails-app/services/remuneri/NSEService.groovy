package remuneri

import grails.gorm.services.Service

@Service(NSE)
interface NSEService {

    NSE get(Serializable id)

    List<NSE> list(Map args)

    Long count()

    void delete(Serializable id)

    NSE save(NSE NSE)

}