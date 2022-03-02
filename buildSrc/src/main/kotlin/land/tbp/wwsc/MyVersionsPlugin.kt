package land.tbp.wwsc

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.extra

class MyVersionsPlugin : Plugin<Project> {
	override fun apply(project: Project) {
		project.extra.set("myversions", Versions)
	}
}
