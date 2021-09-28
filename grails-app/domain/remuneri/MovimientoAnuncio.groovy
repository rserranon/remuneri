package remuneri
import grails.rest.*

@Resource(uri='/movimientosanuncios')
class MovimientoAnuncio {
    Integer   monto
    Date      fecha

    static belongsTo = [anuncio: Anuncio]

    static constraints = {
    }
}
