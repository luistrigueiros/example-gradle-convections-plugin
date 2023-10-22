/*
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package the.plugin

import spock.lang.Specification
import spock.lang.TempDir
import org.gradle.testkit.runner.GradleRunner

/**
 * A simple functional test for the 'the.plugin.greeting' plugin.
 */
class ThePluginPluginFunctionalTest extends Specification {
    @TempDir
    private File projectDir

    private getBuildFile() {
        new File(projectDir, "build.gradle")
    }

    private getSettingsFile() {
        new File(projectDir, "settings.gradle")
    }

    def "can run task"() {
        given:
        settingsFile << ""
        buildFile << """
plugins {
    id('the.plugin.greeting')
}
"""

        when:
        def runner = GradleRunner.create()
        runner.forwardOutput()
        runner.withPluginClasspath()
        runner.withArguments("greeting")
        runner.withProjectDir(projectDir)
        def result = runner.build()

        then:
        result.output.contains("Hello from plugin 'the.plugin.greeting'")
    }
}
