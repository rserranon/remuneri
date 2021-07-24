package remuneri

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PublicoObjetivoController {

    PublicoObjetivoService publicoObjetivoService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond publicoObjetivoService.list(params), model:[publicoObjetivoCount: publicoObjetivoService.count()]
    }

    def show(Long id) {
        respond publicoObjetivoService.get(id)
    }

    def create() {
        respond new PublicoObjetivo(params)
    }

    def save(PublicoObjetivo publicoObjetivo) {
        if (publicoObjetivo == null) {
            notFound()
            return
        }

        try {
            publicoObjetivoService.save(publicoObjetivo)
        } catch (ValidationException e) {
            respond publicoObjetivo.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'publicoObjetivo.label', default: 'PublicoObjetivo'), publicoObjetivo.id])
                redirect publicoObjetivo
            }
            '*' { respond publicoObjetivo, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond publicoObjetivoService.get(id)
    }

    def update(PublicoObjetivo publicoObjetivo) {
        if (publicoObjetivo == null) {
            notFound()
            return
        }

        try {
            publicoObjetivoService.save(publicoObjetivo)
        } catch (ValidationException e) {
            respond publicoObjetivo.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'publicoObjetivo.label', default: 'PublicoObjetivo'), publicoObjetivo.id])
                redirect publicoObjetivo
            }
            '*'{ respond publicoObjetivo, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        publicoObjetivoService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'publicoObjetivo.label', default: 'PublicoObjetivo'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'publicoObjetivo.label', default: 'PublicoObjetivo'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
