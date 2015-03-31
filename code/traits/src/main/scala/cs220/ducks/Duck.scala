package cs220.ducks

object Ducks {

  abstract class Duck {
    def swim: Unit
    def fly: Unit
  }

  abstract class RubberDuck extends Duck with Swims

  trait Swims extends Duck {
    def swim = println("I swim!")
  }

  trait Flier extends Duck {
    def fly = println("I fly!")
  }

  // val d = new RubberDuck with Swims with Flier
}