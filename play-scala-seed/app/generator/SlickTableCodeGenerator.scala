package generator

import com.typesafe.config.ConfigFactory
import slick.codegen._

object SlickTableCodeGenerator extends App {
    val config = ConfigFactory.load
    SourceCodeGenerator.run(
        profile = config.getString("slick.dbs.default.db.profile"),
        jdbcDriver = config.getString("slick.dbs.default.db.driver"),
        url = config.getString("slick.dbs.default.db.url"),
        user = Option(config.getString("slick.dbs.default.db.user")),
        password = Option(config.getString("slick.dbs.default.db.password")),
        outputDir = "./app",
        pkg = "models",
        ignoreInvalidDefaults = true,
    )
}
