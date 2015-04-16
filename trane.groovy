#!/usr/bin/env groovy
import groovy.text.SimpleTemplateEngine

/*
 * Sample tree
 *
[
    [
        name: 'admin',
        type: 'folder',
        children: [
            [
                name: 'login.png',
                type: 'file'
            ],
            [
                name: 'admin.png',
                type: 'file'
            ]
        ]
    ],
    [
        name: 'user.png',
        type: 'file'
    ]
]
 *
 */

// instead of map, return node
// node has method "as map" to generate the map for the binding
Map buildFileTree(File baseDirectory) {
    // read directory files
    // sort them
    // process each
    //   if file, compose node
    //   if directory, backtrack
}

// other properties are read from the args or from config file
// or from both?
// METHOD TO READ OTHER PROPERTIES if necesary

// build binding map
//    uses tree.asMap()

// check if template exists
File getTemplate(String templatePath) {
    File template = new File(templatePath)

    if (!template || !template.isFile()) {
        throw new RuntimeException("The template ${templatePath} does not exist")
    }

    return template
}


// check if binding has all the properties it needs
void checkBinding(Map binding) {
    Closure validProperty = { property, value ->
        value as Boolean  // incomplete
    }

    binding.each { property, value ->
        if (!validProperty(property, value)) {
            throw new RuntimeException("Invalid value ${value} for property ${property}")
        }
    }
}

String renderTemplate(File template, Map binding) {
    SimpleTemplateEngine engine = new SimpleTemplateEngine()

    return engine.createTemplate(template.texe).make(binding)
}
