package server

import akka.http.scaladsl.model.{ContentType, ContentTypes, HttpCharsets, HttpEntity, MediaType}
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.RouteDirectives.complete

object DemoServerRoutes {
  lazy val routes: Route = {
    get {
      getFromDirectory("./DemoServer/public_html/")
    }
  }
}
