package escalate

import org.scalatest.FunSuite
import org.springframework.jndi.JndiObjectFactoryBean
import escalate.spring._
import escalate.spring.Implicits._
import org.springframework.integration.support.MessageBuilder
import collection.JavaConversions._
import org.scalatest.matchers.MustMatchers
import org.springframework.beans.factory.config.PropertiesFactoryBean
import java.util.Properties

/**
 */

class SpringTest extends FunSuite with MustMatchers {
  test("Beans") {
    val ps = bean[PropertiesFactoryBean] { b =>
        val props = new Properties
        props.setProperty("a", "b")
        b.setProperties(props)
    }
    ps.getObject.getProperty("a") must be ("b")
  }

  test("Spring Integraion Message Implicits") {
    val msg = MessageBuilder.withPayload("asdf").copyHeaders(Map("1" -> 1, "2" -> "two")).build()
    msg.header[String]("2") must be (Some("two"))
    msg.headers must (contain key ("1") and contain key ("2"))
    expect(true) {
      msg match {
        case Msg(a: Int) => false
        case Msg("asdf") => true
        case _ => false
      }
    }
  }
}
