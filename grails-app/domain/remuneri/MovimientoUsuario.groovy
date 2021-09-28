package remuneri
import grails.rest.*

@Resource(uri='/movimientosusuario')
class MovimientoUsuario {

    Integer   monto
    Date      fecha 

    static belongsTo = [usuario: Usuario]
    static constraints = {
    }
}
