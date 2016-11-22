package code.service

import com.mongodb._
import net.liftweb.common.Loggable
import net.liftweb.mongodb.MongoDB
import net.liftweb.util.{DefaultConnectionIdentifier, Props}

/**
  * Created by malinee on 21/11/2559.
  */
object MongoConfig extends Loggable{

  def init = {

    val defaultDbAddress = Props.get("mongo.default.url") map (url => new DBAddress(url)) openOr(
                          new DBAddress(Props.get("mongo.default.host","localhost"),
                                        Props.getInt("mongo.default.port",27017),
                                        Props.get("mongo.default.name","mydb"))
      )

    MongoDB.defineDb(DefaultConnectionIdentifier,new MongoClient((defaultDbAddress)),defaultDbAddress.getDBName)

  }

}
