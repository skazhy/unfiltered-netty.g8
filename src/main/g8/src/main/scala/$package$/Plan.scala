package $package$

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import unfiltered.request._
import unfiltered.response._
import unfiltered.netty._
import rx.lang.scala.Observable


object IndexPlan extends async.Plan with ServerErrorResponse {

  def intent = {

    case req @ GET(Path("/")) => req.respond(ResponseString("hello"))

    // A dumb way to respond the request URN.
    // but hey, it demonstrates how to respond to requests in
    // an async manner and makes use of observables.
    case req @ GET(Path(Seg("echo" :: message :: Nil))) =>

      Observable.from(Future.successful(message)).subscribe(
        msg => req.respond(ResponseString(msg))
      )

    case req @ GET(Path("echo")) =>

      Observable.from(Future.failed(new Throwable("Not found"))).subscribe(
          msg => req.respond(ResponseString(msg)),
          err => req.respond(NotFound)
        )

  }

}
