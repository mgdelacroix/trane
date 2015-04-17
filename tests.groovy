@Grab(group='org.spockframework', module='spock-core', version='1.0-groovy-2.4')
import spock.lang.*

class TraneSpec extends Specification {

    Script script = new GroovyShell().parse(new File('trane'))

    void 'Test render template'() {
        given: 'A template file'
            def templateFile = File.createTempFile('template', '.tpl')
            templateFile << 'Hola <%= world %>'

        and: 'a simple binding map'
            def binding = [world: 'mundo']

        when: 'rendering the template'
            def result = script.invokeMethod('renderTemplate', [templateFile, binding])

        then: 'the template should be correctly generated'
            result.class == String
            result == 'Hola mundo'
    }

}
