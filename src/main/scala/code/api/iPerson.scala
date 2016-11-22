package code.api

import code.service.ContactService
import net.liftweb.http.rest.RestHelper

/**
  * Created by malinee on 21/11/2559.
  */
object MyRest extends RestHelper{

  serve(List("api") prefix{
  //  case "country" :: Nil JsonPost data -> req => Test.save(data)
  //  case "country" :: item :: Nil JsonGet _ => Test.find(item)
    case "contact" :: Nil JsonPost data -> req => ContactService.save(data)
    case "contact" :: Nil JsonGet _ => ContactService.findAll
  })

}
