package controllers

import services.AtomicCounter
import javax.inject._
import play.api._
import play.api.mvc._

@Singleton
class CountController @Inject()(counter: AtomicCounter) extends InjectedController {

    def count = Action {
        val count = counter.nextCount()
        Ok(s"""{ "counter": $count }""")
    }
}