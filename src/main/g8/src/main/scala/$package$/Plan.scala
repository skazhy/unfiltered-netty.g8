package $package$

import unfiltered.request._
import unfiltered.response._
import unfiltered.netty._


object IndexPlan extends async.Plan with ServerErrorResponse {

  def intent = {
    case req @ GET(Path("/")) => req.respond(ResponseString("hello"))

    case req @ GET(Path(Seg("echo" :: message :: Nil))) =>
      req.respond(ResponseString(message))

    case req @ GET(Path("/echo")) =>
      err => req.respond(NotFound)
  }
}
