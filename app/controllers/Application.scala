package controllers

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok(views.html.index())
  }

  def memory = Action{
    Ok(views.html.memory())
  }
  def math = Action {
    Ok(views.html.math())
  }
  def intuition = Action {
    Ok(views.html.intuition())
  }
}