package com.github.yoshiyoshifujii.miroapp.actor

import akka.actor.typed.{ ActorRef, Behavior }
import akka.actor.typed.scaladsl.Behaviors
import com.github.yoshiyoshifujii.miroapp.domain.AccessToken

object Authorization {

  sealed trait Command
  final case class GetCommand(replyTo: ActorRef[GetReply]) extends Command
  final case class GetReply(accessToken: AccessToken)

  def apply(): Behavior[Command] =
    Behaviors.setup { context =>
      val accessToken = context.system.settings.config.getString("miro-app.accessToken")
      Behaviors.receiveMessage {
        case GetCommand(replyTo) =>
          replyTo ! GetReply(AccessToken(accessToken))
          Behaviors.same
      }
    }

}
