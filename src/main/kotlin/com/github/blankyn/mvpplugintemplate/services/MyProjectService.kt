package com.github.blankyn.mvpplugintemplate.services

import com.intellij.openapi.project.Project
import com.github.blankyn.mvpplugintemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
