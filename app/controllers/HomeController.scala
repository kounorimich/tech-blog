package controllers

import javax.inject._
import play.api.mvc._
import play.api.db._
import scalikejdbc._
import scalikejdbc.ConnectionPool
import models.Post
import PostForm._
import java.util.Date
import java.text.SimpleDateFormat

@Singleton
class HomeController @Inject()(db: Database,
                               cc: MessagesControllerComponents)
  extends MessagesAbstractController(cc) {

  Class.forName("org.h2.Driver")

  ConnectionPool.singleton("jdbc:h2:mem:mydatabase", "user", "password")

  def index() = Action { implicit request =>
    DB.readOnly { implicit session =>
      val posts = sql"""select * from posts""".map(Post.apply).list.apply


      Ok(views.html.index(posts))
    }

  }

  def show(id: Long) = Action { implicit request =>
    DB readOnly { implicit session =>
      val post: Option[Post] = sql"""select * from posts where id=${id}""".map(Post.apply).single.apply()
      if (post == None) {
        Ok(views.html.show(Post.hoge()))
      } else {
        Ok(views.html.show(post.get))
      }
    }
  }

  def edit(id: Long) = Action { implicit request =>
    DB readOnly {implicit session =>
      val post: Post = sql"""select * from posts where id=${id}""".map(Post.apply).single.apply().get
//      val data = PostData(post.createdAt, post.title, post.body)
      println("---------------" + post.createdAt, post.title, post.body)

      val data = createPostDataFromPost(post)
      println(":::::::::::::::::::::::::" + data)
      val formData = postForm.fill(data)
      Ok(views.html.edit(formData, post.id))
    }
  }

  def update(id: Long) = TODO
}

