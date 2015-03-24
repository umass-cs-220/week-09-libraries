package cs220.queue

import scala.collection.mutable.ArrayBuffer

abstract class IntQueue {
  def get(): Int
  def put(x: Int): Unit
}

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) {
    buf += x
  }
}



// Here is some added functionality:

trait Doubling extends IntQueue {
  abstract override def put(x: Int) {
    super.put(2 * x)
  }
}

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) {
    super.put(x + 1)
  }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}

/*
 // You can then create variants on a base queue:

 > val q1 = new BasicIntQueue with Doubling
 > val q2 = new BasicIntQueue with Incrementing
 > val q3 = new BasicIntQueue with Filtering

 // Or even combine different traits:
 > val q4 = new BasicIntQueue with Doubling with Incrementing
 > val q5 = new BasicIntQueue with Doubling with Incrementing with Filtering

 // What about this:
 > val q6 = new BasicIntQueue with Incrementing with Doubling with Filtering

 ////////////////////////////////////////////////////////////////////
 // i-clicker:
 ////////////////////////////////////////////////////////////////////
 // Does ordering matter? What do you think?
 //
 // A) Yes
 // B) No
 //
 ////////////////////////////////////////////////////////////////////

*/