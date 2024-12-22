package edu.tyut

import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.Element


fun parseYaml(yaml: String): dynamic {
    val jsYaml = js("require('js-yaml')")
    return jsYaml.load(yaml)
}

fun main() {
    val yamlData = """
        name: Kotlin
        version: 1.9.0
        dataList:
            - 1
            - 2
    """
    val result: String = parseYaml(yamlData)
    document.writeln("Parsed YAML: ${JSON.stringify(result)}")

    window.onload = {
        val click: Element? = document.getElementById("click")
        // document.writeln("click: $click")
        val axios: dynamic = js("require('axios')")
        click?.addEventListener("click", {
            try {
                // 有跨域问题
                val response: dynamic = axios.get("http://localhost:8080/Spring_MVC_01/hello")
                // document.writeln("Response: ${response.data}")
                console.log("Response: ${
                    response.then { response: dynamic ->
                        println("Response: ${response.data}")
                    }
                    .catch { error: dynamic ->
                        println("Error: ${error.message}")
                    }
                }")
            } catch (e: dynamic) {
                console.log("Error: ${e.message}")
            }
        })
    }


}
