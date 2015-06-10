package lstore.sql

import lstore.LStoreSpec

/**
 *
 */
class SQLParserTest extends LStoreSpec
{
  "SQLParser" should {

    "parse select statement" in {
      val p = SQLParser.parse("select 1")
      info(p)
    }

  }


}
