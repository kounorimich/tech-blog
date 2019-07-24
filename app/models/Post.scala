package models

import java.util.{Calendar, Date}

import org.joda.time.DateTime
import scalikejdbc._
import scalikejdbc.JavaUtilDateConverter

case class Post(
                 id: Long,
                 createdAt: Date,
                 title: String,
                 body: String
               )

object Post extends SQLSyntaxSupport[Post] {
  def hoge() = apply(9999, new Date(), "", "")

  def apply(rs: WrappedResultSet): Post =
    new Post(
      id = rs.long("id"),
      createdAt = rs.date("createdAt"),
      title = rs.string("title"),
      body = rs.string("body")
    )
}

object PostForm {

  import play.api.data._
  import play.api.data.Forms._

  case class postData(id: Long, createdAt: Date, title: String, body: String)

  val postForm = Form(
    mapping(
      "id" -> longNumber,
      "createdAt" -> date,
      "title" -> text,
      "body" -> text
    )(postData.apply)(postData.unapply)
  )
}