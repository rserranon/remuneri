package remuneri
 import grails.rest.*
 
@Resource(uri='/respuestas')
class Respuesta {
    
    Integer   secuencia
    String    respuesta

    static constraints = {
    }
}
