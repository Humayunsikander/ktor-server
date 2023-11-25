package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Welcome to Ktor Humayun")
        }

        /**
         * Routes are used to group calls with same path
         */
        route("notes") {
            post {
                val body = call.receive<String>()
                call.respond(body)
            }

            delete {
                val body = call.receive<String>()
                call.respond(body)
            }

            /**
             * We can also make nested routes
              */
            route("/create") {
                post {
                    val body = call.receive<String>()
                    call.respond(body)
                }
            }

            /**
             * Passing path parameter in url
             */
            get("/{id}") {
                val id = call.parameters.get("id")
                call.respond(id.toString())
            }

            /**
             * Passing query parameter
             */
            get {
                val id = call.request.queryParameters["id"]
                call.respond(id.toString())
            }
        }
    }
}
