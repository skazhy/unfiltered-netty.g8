package $package$


object Server {

  def main(args: Array[String]) {
    unfiltered.netty.Http(8080)
      .handler(IndexPlan)
      .run()
  }

}
