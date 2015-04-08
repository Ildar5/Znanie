package controllers

import models._
import play.api.Logger
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.mvc._

import scala.slick.lifted.TableQuery

class Informations extends Controller {

  val people = TableQuery[PersonTable]


  def showAddForm = Action {
    Ok(views.html.add())
  }

  def add = DBAction { implicit request =>
    val formParams = request.body.asFormUrlEncoded
    val name = formParams.get("name")(0)
    val description = formParams.get("description")(0)
    val country = formParams.get("country")(0)

    val personId = (people returning people.map(_.id)) += Person(None, name, description, country)
    Logger.info(s"LastId = $personId")
    Redirect(routes.Informations.RatingList())
  }


  def remove(id: Int) = DBAction { implicit request =>
    people.filter(_.id === id).delete
    Redirect(routes.Informations.RatingList())
  }



  def RatingList = DBAction { implicit rs =>
    Logger.info(s"SHOW_ALL = ${people.list}")
    Ok(views.html.rating(people.list))
  }



}