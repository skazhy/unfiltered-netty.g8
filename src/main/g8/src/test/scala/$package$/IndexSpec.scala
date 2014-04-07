package $package$

import org.specs2.mutable._
import scala.concurrent.ExecutionContext.Implicits.global
import dispatch._


object IndexSpec extends Specification with unfiltered.specs2.netty.Served {

  def setup = { _.handler(IndexPlan) }

  implicit def toReq(urn: String): Req = url(s"http://\${host.host.getHostName}:\${port}\$urn")

  def call(request: Req) = {
    val r = Http(request)
    r()
  }

  "The example app" should {

    lazy val request = call("/")

    "return OK status" in {
      request.getStatusCode mustEqual 200
    }

    "return example text" in {
      request.getResponseBody mustEqual "hello"
    }
  }

}
