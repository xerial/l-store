package lstore

import org.scalatest._
import xerial.core.io.Resource
import xerial.core.log.Logger
import xerial.core.util.Timer

trait LStoreSpec
        extends WordSpec with Matchers with GivenWhenThen with OptionValues with Resource with Timer with Logger with BeforeAndAfter
{
}
