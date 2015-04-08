package models

import play.api.db.slick.Config.driver.simple._

case class Person(id: Option[Int],
                name: String,
                description: String,
                country: String)


class PersonTable(tag: Tag) extends Table[Person](tag, "UZCITY") {

  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

  def name = column[String]("NAME", O.Default(""))

  def description = column[String]("DESCRIPTION", O.Default(""))

  def country = column[String]("COUNTRY", O.Default(""))

  def * = (id.?, name, description, country) <> (Person.tupled, Person.unapply _)

}
