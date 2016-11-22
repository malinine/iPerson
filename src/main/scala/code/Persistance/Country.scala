package code.Persistance

import net.liftweb.mongodb.record._
import net.liftweb.mongodb.record.field._

/**
  * Created by malinee on 18/11/2559.
  */
class Country private () extends MongoRecord[Country] with StringPk[Country] {
  override def meta = Country
  object name extends MongoMapField[Country,Int](this)
}
object Country extends Country with MongoMetaRecord[Country] {
  override def collectionName = "example.earth"
}

