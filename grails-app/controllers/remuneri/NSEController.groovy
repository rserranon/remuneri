package remuneri

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NSEController {

    NSEService NSEService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond NSEService.list(params), model:[NSECount: NSEService.count()]
    }

    def show(Long id) {
        respond NSEService.get(id)
    }

    def create() {
        respond new NSE(params)
    }

    def save(NSE NSE) {
        if (NSE == null) {
            notFound()
            return
        }

        try {
            NSEService.save(NSE)
        } catch (ValidationException e) {
            respond NSE.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'NSE.label', default: 'NSE'), NSE.id])
                redirect NSE
            }
            '*' { respond NSE, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond NSEService.get(id)
    }

    def update(NSE NSE) {
        if (NSE == null) {
            notFound()
            return
        }

        try {
            NSEService.save(NSE)
        } catch (ValidationException e) {
            respond NSE.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'NSE.label', default: 'NSE'), NSE.id])
                redirect NSE
            }
            '*'{ respond NSE, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        NSEService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'NSE.label', default: 'NSE'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'NSE.label', default: 'NSE'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
