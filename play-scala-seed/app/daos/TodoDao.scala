package daos

import models.Tables.Todo
import slick.jdbc.PostgresProfile.api._


object TodoDao {

  lazy val db = Database.forConfig("slick.dbs.default.db")

  /**
    * Todoの作成
    *
    * @param title
    * @param text
    */
  def create(title: String, text: String) = {
    val query = (Todo.map(todo => (todo.title, todo.text)) += (title, text)).asTry
    db.run(query)
  }
}