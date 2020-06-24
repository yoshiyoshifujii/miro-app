package com.github.yoshiyoshifujii.miroapp.actor

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}

object Widget {

  sealed trait Command
  final case class ListAllCommand(replyTo: ActorRef[ListAllReply]) extends Command
  final case class ListAllReply()

  def apply(): Behavior[Command] =
    Behaviors.setup { context =>
      Behaviors.receiveMessage {
        case ListAllCommand(replyTo) =>
          replyTo ! ListAllReply()
          Behaviors.same
      }
    }

}
