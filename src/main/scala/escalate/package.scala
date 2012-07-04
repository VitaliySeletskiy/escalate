package escalate

import org.springframework.beans.factory.InitializingBean
import org.springframework.context.ApplicationContext

/**
 */

package object spring {
  /**
   * Creates Spring bean.
   * Automatically calls afterPropertiesSet() after you set properties within setProperties function.
   *
   * @example
   * {{{
   *   val jmsTpl = bean[JndiObjectFactoryBean] { b =>
   *     b.setJndiName("name")
   *     ...
   *   }
   * }}}
   *
   * @param setProperties
   * @tparam A
   * @return
   */
  def bean[A <: InitializingBean : Manifest](setProperties: A => Unit) = {
    val b = manifest[A].erasure.newInstance().asInstanceOf[A]
    setProperties(b)
    b.afterPropertiesSet()
    b
  }

  /**
   * Looks for a Spring bean named beanName.
   *
   * @example
   * {{{
   *   import escalate.spring._
   *   implicit val ctx = new ClassPathXmlApplicationContext("context.xml")
   *   val myBean = bean[MyClass]("myBeanName")
   * }}}
   *
   * @param beanName a bean name to find
   * @param appCtx implicit [[org.springframework.context.ApplicationContext]] parameter
   * @tparam A
   * @return
   */
  def bean[A](beanName: String)(implicit appCtx: ApplicationContext, m: Manifest[A]) = appCtx.getBean(beanName, m.erasure)
}

