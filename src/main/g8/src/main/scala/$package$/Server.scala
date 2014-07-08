package $package$

import com.netflix.discovery.{DefaultEurekaClientConfig, DiscoveryManager}
import com.netflix.appinfo.{CloudInstanceConfig, ApplicationInfoManager}
import com.netflix.appinfo.InstanceInfo.InstanceStatus


object Server {

  val useEureka = true

  def changeInstanceStatus(newStatus: InstanceStatus) =
    if (useEureka) ApplicationInfoManager.getInstance.setInstanceStatus(newStatus)

  if (useEureka) {
    DiscoveryManager.getInstance.initComponent(
      new CloudInstanceConfig() {
        override def getAppname = "linkedout"
      },
      new DefaultEurekaClientConfig()
    )
  }

  ApplicationInfoManager.getInstance().setInstanceStatus(InstanceStatus.STARTING)

  def main(args: Array[String]) {
    unfiltered.netty.Http(8080)
      .handler(IndexPlan)
      .run(
        _ => setInstanceStatus(InstanceStatus.UP),
        _ => setInstanceStatus(InstanceStatus.DOWN))
  }

  sys.addShutdownHook(setInstanceStatus(InstanceStatus.OUT_OF_SERVICE))

}
