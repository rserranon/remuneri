package remuneri
import grails.rest.*

@Resource(uri='/preguntas')
class Pregunta {
    String    pregunta
    
    static hasMany = [respuestas: Respuesta]
    static constraints = {
    }
}
