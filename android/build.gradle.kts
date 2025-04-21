import org.gradle.api.tasks.Delete

plugins {
    // Aplica los plugins al proyecto raíz, utilizando el catálogo de versiones.
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.google.services) apply false
}

// Configuración de la nueva ruta del build
val newBuildDir: Directory = rootProject.layout.buildDirectory.dir("../../build").get()
rootProject.layout.buildDirectory.value(newBuildDir)

subprojects {
    val newSubprojectBuildDir: Directory = newBuildDir.dir(project.name)
    project.layout.buildDirectory.value(newSubprojectBuildDir)
}

// Evaluación de la dependencia con el módulo app
subprojects {
    project.evaluationDependsOn(":app")
}

// Tarea de limpieza
tasks.register<Delete>("clean") {
    delete(rootProject.layout.buildDirectory)
}