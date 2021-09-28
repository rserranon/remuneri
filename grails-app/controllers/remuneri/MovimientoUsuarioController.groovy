package remuneri

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class MovimientoUsuarioController {

    MovimientoUsuarioService movimientoUsuarioService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond movimientoUsuarioService.list(params), model:[movimientoUsuarioCount: movimientoUsuarioService.count()]
    }

    def show(Long id) {
        respond movimientoUsuarioService.get(id)
    }

    def create() {
        respond new MovimientoUsuario(params)
    }

    def save(MovimientoUsuario movimientoUsuario) {
        if (movimientoUsuario == null) {
            notFound()
            return
        }

        try {
            movimientoUsuarioService.save(movimientoUsuario)
        } catch (ValidationException e) {
            respond movimientoUsuario.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'movimientoUsuario.label', default: 'MovimientoUsuario'), movimientoUsuario.id])
                redirect movimientoUsuario
            }
            '*' { respond movimientoUsuario, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond movimientoUsuarioService.get(id)
    }

    def update(MovimientoUsuario movimientoUsuario) {
        if (movimientoUsuario == null) {
            notFound()
            return
        }

        try {
            movimientoUsuarioService.save(movimientoUsuario)
        } catch (ValidationException e) {
            respond movimientoUsuario.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'movimientoUsuario.label', default: 'MovimientoUsuario'), movimientoUsuario.id])
                redirect movimientoUsuario
            }
            '*'{ respond movimientoUsuario, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        movimientoUsuarioService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'movimientoUsuario.label', default: 'MovimientoUsuario'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'movimientoUsuario.label', default: 'MovimientoUsuario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
