package remuneri

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class InteresController {

    InteresService interesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond interesService.list(params), model:[interesCount: interesService.count()]
    }

    def show(Long id) {
        respond interesService.get(id)
    }

    def create() {
        respond new Interes(params)
    }

    def save(Interes interes) {
        if (interes == null) {
            notFound()
            return
        }

        try {
            interesService.save(interes)
        } catch (ValidationException e) {
            respond interes.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'interes.label', default: 'Interes'), interes.id])
                redirect interes
            }
            '*' { respond interes, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond interesService.get(id)
    }

    def update(Interes interes) {
        if (interes == null) {
            notFound()
            return
        }

        try {
            interesService.save(interes)
        } catch (ValidationException e) {
            respond interes.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'interes.label', default: 'Interes'), interes.id])
                redirect interes
            }
            '*'{ respond interes, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        interesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'interes.label', default: 'Interes'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'interes.label', default: 'Interes'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
