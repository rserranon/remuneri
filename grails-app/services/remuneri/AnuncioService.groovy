package remuneri

import grails.gorm.services.Service

@Service(Anuncio)
interface AnuncioService {

    Anuncio get(Serializable id)

    List<Anuncio> list(Map args)

    Long count()

    void delete(Serializable id)

    Anuncio save(Anuncio anuncio)

}