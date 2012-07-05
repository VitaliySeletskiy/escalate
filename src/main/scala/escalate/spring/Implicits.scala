package escalate.spring

import org.springframework.integration.Message
import collection.JavaConversions._

/**
 */
object Implicits {
  implicit def MessageHeaders2Map(m: Message[_]) = new RichMessage(m)

  class RichMessage(m: Message[_]) {
    def header[A](key: String): Option[A] = Option(m.getHeaders.get(key).asInstanceOf[A])
    def headers = mapAsScalaMap(m.getHeaders)
  }

  object Msg {
    def unapply(m: Message[_]) = Some(m.getPayload)
  }

}
