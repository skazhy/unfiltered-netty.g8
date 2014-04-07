package $package$


object Server {

  def main(args: Array[String]) {
    unfiltered.netty.Http(8080)
      .handler(IndexPlan)
      .run(_ => unfiltered.util.Browser.open(s"http://127.0.0.1:8080"))
  }

}
