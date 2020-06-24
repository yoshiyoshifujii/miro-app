package com.github.yoshiyoshifujii.miroapp.actor

import akka.actor.testkit.typed.scaladsl.{ ActorTestKit, ActorTestKitBase }
import com.github.yoshiyoshifujii.miroapp.domain.AccessToken
import com.typesafe.config.ConfigFactory
import org.scalatest.freespec.AnyFreeSpecLike

class AuthorizationSpec
    extends ActorTestKitBase(
      ActorTestKit(
        ConfigFactory
          .parseString("""
    |""".stripMargin).withFallback(ConfigFactory.load())
      )
    )
    with AnyFreeSpecLike {

  override protected def afterAll(): Unit = {
    testKit.shutdownTestKit()
  }

  "Authorization" - {
    "success" in {

      val probe = testKit.createTestProbe[Authorization.GetReply]

      val ref = testKit.spawn(Authorization())
      ref ! Authorization.GetCommand(probe.ref)

      probe.expectMessage(Authorization.GetReply(AccessToken("xxx")))
    }
  }

}
