package cs220.queue2

/** A "faster" functional queue.
  *
  * This functional queue uses a functional [List] as its internal
  * implementation of a queue.
  *
  * In this impementation we keep two lists: one for the leading
  * elements that we will dequeue from and trailing elements which
  * represent the end of the queue.
  */
class FasterQueue[T] private [queue2] (
  // We use the val syntax and private in the constructor to create
  // member variables representing the leading and trailing elements
  // as well as private for information hiding:
  private val leading: List[T],
  private val trailing: List[T]
) extends Queue[T] {
  // mirror returns a queue with leading elements.
  //
  // In particular, if we have no leading elements we create a new
  // queue with its leading elements being the reverse of the trailing
  // elements and Nil as its trailing elements. If we do have leading
  // elements then we do nothing.
  //
  // We use private to hide this method from outside this class.
  private def mirror =
    if (leading.isEmpty)
      new FasterQueue(trailing.reverse, Nil)
    else
      this

  // The head of the queue is the head of the mirror of this queue.
  //
  // i-clicker: In what circumstance is this method not efficient?
  //
  // A) When leading contains elements.
  // B) When trailing is empty.
  // C) When head is called repeatedly without a call to tail.
  // D) When tail is called repeatedly without a call to head.
  // E) This method is always efficent.
  //
  def head = mirror.leading.head

  // The tail of the queue is a new queue where the leading elements
  // are the tail of the mirror of this queue and its trailing elements
  // are the trailing elements of the mirror.
  def tail = {
    val q = mirror
    new FasterQueue(q.leading.tail, q.trailing)
  }

  // enqueue create a new queue with the leading elements being the
  // leading elements of the new queue and the trailing elements being
  // a new list constructed by consing the new element x to the
  // trailing elements.
  def enqueue(x: T) =
    new FasterQueue(leading, x :: trailing)

  // We add a toString method to print it out nicely:
  override def toString = {
    val xs = leading ::: trailing.reverse
    "Queue(" + xs.mkString(",") + ")"
  }
}
