package lstore.sql

import lstore.LStoreSpec
import org.antlr.v4.runtime.tree.ParseTreeWalker
import org.antlr.v4.runtime.{CommonTokenStream, ANTLRInputStream, CharStream}

/**
 *
 */
class SQLParserTest extends LStoreSpec
{
  "SQLParser" should {

    "parse select statement" in {

      val lexer = new SQLLexer(new ANTLRInputStream("select * from A"))
      val tokens = new CommonTokenStream(lexer)
      val parser = new SQLParser(tokens)
      parser.setBuildParseTree(true)
      parser.setTrace(true)

      val sqlContext = parser.sql()
      import scala.collection.JavaConversions._
      info(sqlContext.toStringTree(SQLParser.ruleNames.toList))


    }

  }


}
