package org.functionalkoans.forscala

import support.KoanSuite
import org.scalatest.matchers.ShouldMatchers

class AboutPatternMatching extends KoanSuite with ShouldMatchers{

  koan("matching can be done against list elements"){
    val l = List(1,2,3,4,5,6)
    val matchResult = l match {
      case List(1, x, _*) => x
    }

    matchResult should be(2)
  }

  koan("matching can be nested"){
    val l = List(1,2,(3,4),5,6)
    val matchResult = l match {
      case List(1, _, (3, x) , _*) => x
    }

    matchResult should be(4)
  }

  koan("throws MatchError when no match found"){
    val l = List(1,2,3,4,5,6)
    intercept[MatchError]{
      l match {
        case Nil => "OK"
      }
    }
  }
}