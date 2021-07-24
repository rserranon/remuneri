package remuneri
import grails.rest.*
 
@Resource(uri='/publicoobjetivo')

class PublicoObjetivo {
    String  nombre
    Integer edadDe
    Integer edadHasta
    String  nse
    String  sistemaOperativo
    BigDecimal  latitud
    BigDecimal  longitud
    BigDecimal  radio
    // static belongsTo = [anuncio: Anuncio] used only with scafolfing testing
    static constraints = {
          nombre    size: 5..25, blank: false, unique: true
          edadDe    min: 18, max: 99
          edadHasta min: 18, max: 99
          nse (inList:["A", "B", "C+", "C"])
          sistemaOperativo (inList:["iOS", "Android", "Otro"])
          latitud     (min: new BigDecimal(-90.0), max: new BigDecimal(90.0))
          longitud    (min: new BigDecimal(-180.0), max: new BigDecimal(180.0))
          radio       (min: new BigDecimal(0.0), max: new BigDecimal(1000.0))
    }
}
