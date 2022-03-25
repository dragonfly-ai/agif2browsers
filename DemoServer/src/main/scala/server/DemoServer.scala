package server

import akka.http.scaladsl.Http

/**
 * server runs on localhost to provide browserDemo with example images that do not violate cross origin security policies.
 */

object DemoServer extends App {
  println("Binding to ports.")
  Http().newServerAt("0.0.0.0", 8080).bindFlow(DemoServerRoutes.routes)
}
