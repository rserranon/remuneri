package remuneri
 import grails.rest.*

 @Resource(uri='/anuncios')

class Anuncio {
	String      nombre
	String 	    descripcion
	Integer     monto
	BigDecimal 	latitud
  BigDecimal  longitud
	BigDecimal	radio
	Date	      de
	Date	      hasta
	Boolean     lunes
	Date 	      lunesDe
	Date	      lunesA

  static hasMany = [ publicos: PublicoObjetivo]

  static constraints = {
        nombre      size: 5..25, blank: false, unique: true
        descripcion size: 5..35, blank: false
        monto       min: 0
        latitud     (min: new BigDecimal(-90.0), max: new BigDecimal(90.0)) 
        longitud    (min: new BigDecimal(-180.0), max: new BigDecimal(180.0))
        radio       (min: new BigDecimal(0.0), max: new BigDecimal(1000.0)) 
        de          blank: false
        hasta       blank: false
        lunesDe     blank: false
        lunesA      blank: false
    }
}
