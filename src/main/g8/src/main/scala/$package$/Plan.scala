package $package$

import unfiltered.request._
import unfiltered.response._

import unfiltered.netty._


object IndexPlan extends async.Plan with ServerErrorResponse {

  def intent = {

    case req @ GET(Path("/")) => req.respond(ResponseString("hello"))

  }

}
