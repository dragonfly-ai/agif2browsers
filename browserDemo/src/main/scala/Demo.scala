import org.scalajs.dom
import dom.{HTMLImageElement, document}

object Demo {

  def main(args: Array[String]): Unit = {

    dom.window.addEventListener("load", ev => {
      val body = dom.window.document.body

      val p = document.createElement("p")
      p.textContent = "Testing 1 2 3"

      body.appendChild(p)
    })
  }
 }
