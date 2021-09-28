package remuneri
import grails.rest.*

@Resource(uri='/contenidos')

class Contenido {
    String      nombreArchivo
    Integer     secuencia
    BigDecimal  tiempo
    
    static constraints = {
    }
}
