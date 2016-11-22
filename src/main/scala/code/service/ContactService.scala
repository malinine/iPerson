package code.service


import net.liftweb.common.Full
import net.liftweb.http.LiftResponse
import net.liftweb.http.rest.RestHelper
import net.liftweb.json.JsonAST.JValue
import net.liftweb.json.JsonDSL._

/**
  * Created by malinee on 21/11/2559.
  */
object ContactService extends RestHelper{

  def findAll: LiftResponse = {
    val allContact: JValue =
      for {
        listContact <-  code.Persistance.Contact.findAll
      } yield listContact.asJValue
    allContact
  }

  def findByName(name: String): LiftResponse = {

     code.Persistance.Contact.find(("name" -> name))


  }

  def save(data: JValue): LiftResponse = {
    val contact = data.extract[code.model.Contact]
    val addContact = code.Persistance.Contact.createRecord
  //  addContact.name(contact.name)
  //  addContact.phone(contact.phone)
    addContact.setFieldsFromJValue(data)
    addContact.save() match {
      case contact => ("res"->"ok") ~ Nil: JValue
      case _ =>  ("res"->"Bad") ~ Nil: JValue
    }

  }


}
