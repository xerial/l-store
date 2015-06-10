package lstore.sql
import org.parboiled2._


object SQLParser {

  def parse(sql:String) = {
    new SQLParser(sql).SelectExpr.run()
  }

}

case class Select(expr:Seq[Any])
trait Expr
case class IntExpr(v:Int) extends Expr

/**
 *
 */
class SQLParser(val input:ParserInput) extends Parser {

  import CharPredicate.{Digit, Digit19, HexDigit}
  implicit def toStringMatchRule(s: String) = rule { ignoreCase(s) ~ WhiteSpaces }

  def WhiteSpaces = rule { zeroOrMore(CharPredicate(" \n\r\t\f")) }

  def SelectExpr = rule {
    "select" ~ zeroOrMore(Expr ~ zeroOrMore("," ~ Expr)) ~ optional(From ) ~> (i => Select(Seq.empty))
  }

  def Number = rule { Integer ~ optional(Frac) ~ optional(Exp) }
  def Integer = rule { optional('-') ~ (Digit19 ~ Digits | Digit) }
  def Digits = rule { oneOrMore(Digit) }

  def Frac = rule { "." ~ Digits }
  def Exp = rule { ignoreCase('e') ~ optional(anyOf("+-")) ~ Digits }

  def Expr = rule {
    Integer
  }

  def From = rule {
    "from"
  }

}
