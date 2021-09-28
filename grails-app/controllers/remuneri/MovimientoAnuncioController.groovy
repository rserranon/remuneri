package remuneri

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MovimientoAnuncioController {

    MovimientoAnuncioService movimientoAnuncioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond movimientoAnuncioService.list(params), model:[movimientoAnuncioCount: movimientoAnuncioService.count()]
    }

    def show(Long id) {
        respond movimientoAnuncioService.get(id)
    }

    def create() {
        respond new MovimientoAnuncio(params)
    }

    def save(MovimientoAnuncio movimientoAnuncio) {
        if (movimientoAnuncio == null) {
            notFound()
            return
        }

        try {
            movimientoAnuncioService.save(movimientoAnuncio)
        } catch (ValidationException e) {
            respond movimientoAnuncio.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'movimientoAnuncio.label', default: 'MovimientoAnuncio'), movimientoAnuncio.id])
                redirect movimientoAnuncio
            }
            '*' { respond movimientoAnuncio, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond movimientoAnuncioService.get(id)
    }

    def update(MovimientoAnuncio movimientoAnuncio) {
        if (movimientoAnuncio == null) {
            notFound()
            return
        }

        try {
            movimientoAnuncioService.save(movimientoAnuncio)
        } catch (ValidationException e) {
            respond movimientoAnuncio.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'movimientoAnuncio.label', default: 'MovimientoAnuncio'), movimientoAnuncio.id])
                redirect movimientoAnuncio
            }
            '*'{ respond movimientoAnuncio, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        movimientoAnuncioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'movimientoAnuncio.label', default: 'MovimientoAnuncio'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'movimientoAnuncio.label', default: 'MovimientoAnuncio'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
