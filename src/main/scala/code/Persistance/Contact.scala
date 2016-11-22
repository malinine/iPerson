package code.Persistance

import net.liftweb.mongodb.record.field.ObjectIdPk
import net.liftweb.mongodb.record.{MongoMetaRecord, MongoRecord}
import net.liftweb.record.field.StringField

/**
  * Created by malinee on 21/11/2559.
  */
class Contact private() extends MongoRecord[Contact] with ObjectIdPk[Contact]{
  override def meta = Contact
  object name extends StringField(this,20)
  object phone extends StringField(this,10)

}
object Contact extends Contact with MongoMetaRecord[Contact]