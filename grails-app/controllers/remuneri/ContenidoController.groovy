package remuneri

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ContenidoController {

    ContenidoService contenidoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond contenidoService.list(params), model:[contenidoCount: contenidoService.count()]
    }

    def show(Long id) {
        respond contenidoService.get(id)
    }

    def create() {
        respond new Contenido(params)
    }

    def save(Contenido contenido) {
        if (contenido == null) {
            notFound()
            return
        }

        try {
            contenidoService.save(contenido)
        } catch (ValidationException e) {
            respond contenido.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'contenido.label', default: 'Contenido'), contenido.id])
                redirect contenido
            }
            '*' { respond contenido, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond contenidoService.get(id)
    }

    def update(Contenido contenido) {
        if (contenido == null) {
            notFound()
            return
        }

        try {
            contenidoService.save(contenido)
        } catch (ValidationException e) {
            respond contenido.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'contenido.label', default: 'Contenido'), contenido.id])
                redirect contenido
            }
            '*'{ respond contenido, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        contenidoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'contenido.label', default: 'Contenido'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'contenido.label', default: 'Contenido'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
