package org.functionalkoans.forscala

import support.KoanSuite
import org.scalatest.matchers.ShouldMatchers
import scala.xml.{Node, XML}

/**
 * Check http://www.ibm.com/developerworks/library/x-scalaxml/
 */
class AboutXml extends KoanSuite with ShouldMatchers{

  koan("Can read xml from file"){
    val xml = XML.loadFile("pom.xml")
    xml.toString should include ("<artifactId>scala-koans</artifactId>")    
  }

  koan("Nodes can be searched"){
    val xml = XML.loadFile("pom.xml")
    val dependencies : Seq[Node] = xml\"dependencies"\"dependency"

    assert(dependencies.exists{n:Node => n\"groupId" == "junit"}, "Contains junit dependency")

  }
}