package controllers

import java.util.Date
import java.text.SimpleDateFormat
import models.Post


object PostForm {
  import play.api.data._
  import play.api.data.Forms._

  val sdFormat = new SimpleDateFormat("yyyy/MM/DD")

  def createPostDataFromPost(post: Post): PostData = {
      val formattedDate = sdFormat.format(post.createdAt)
      PostData(formattedDate, post.title, post.body)
    }

  case class PostData(formattedDate: String, title: String, body: String)

  val postForm = Form(
    mapping(
      "createdAt" -> text,
      "title" -> text,
      "body" -> text
    )(PostData.apply)(PostData.unapply)
  )
}
