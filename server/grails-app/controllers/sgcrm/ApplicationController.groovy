package sgcrm

import grails.converters.JSON
import grails.core.GrailsApplication
import grails.plugin.springsecurity.annotation.Secured
import grails.plugins.GrailsPluginManager
import grails.plugins.PluginManagerAware
import org.springframework.http.HttpStatus

class ApplicationController implements PluginManagerAware {

    GrailsApplication grailsApplication
    GrailsPluginManager pluginManager

    def index() {
        [grailsApplication: grailsApplication, pluginManager: pluginManager]
    }

    @Secured(value = ['isAuthenticated()'])
    def checkAuth() {
        render(status: HttpStatus.OK)
    }

    @Secured(value = ['isAuthenticated()'])
    def currentUserId() {
        render([id: authenticatedUser?.id] as JSON)
    }
}
