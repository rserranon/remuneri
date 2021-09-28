package remuneri

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class SistemaOperativoController {

    SistemaOperativoService sistemaOperativoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond sistemaOperativoService.list(params), model:[sistemaOperativoCount: sistemaOperativoService.count()]
    }

    def show(Long id) {
        respond sistemaOperativoService.get(id)
    }

    def create() {
        respond new SistemaOperativo(params)
    }

    def save(SistemaOperativo sistemaOperativo) {
        if (sistemaOperativo == null) {
            notFound()
            return
        }

        try {
            sistemaOperativoService.save(sistemaOperativo)
        } catch (ValidationException e) {
            respond sistemaOperativo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'sistemaOperativo.label', default: 'SistemaOperativo'), sistemaOperativo.id])
                redirect sistemaOperativo
            }
            '*' { respond sistemaOperativo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond sistemaOperativoService.get(id)
    }

    def update(SistemaOperativo sistemaOperativo) {
        if (sistemaOperativo == null) {
            notFound()
            return
        }

        try {
            sistemaOperativoService.save(sistemaOperativo)
        } catch (ValidationException e) {
            respond sistemaOperativo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'sistemaOperativo.label', default: 'SistemaOperativo'), sistemaOperativo.id])
                redirect sistemaOperativo
            }
            '*'{ respond sistemaOperativo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        sistemaOperativoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'sistemaOperativo.label', default: 'SistemaOperativo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'sistemaOperativo.label', default: 'SistemaOperativo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
