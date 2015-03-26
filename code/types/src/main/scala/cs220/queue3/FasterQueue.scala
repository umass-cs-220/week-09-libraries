package cs220.queue3

/** A "faster" functional queue.
  *
  * This functional queue uses a functional [List] as its internal
  * implementation of a queue.
  *
  * In this impementation we keep two lists: one for the leading
  * elements that we will dequeue from and trailing elements which
  * represent the end of the queue.
  */
class FasterQueue[T] private [queue3] (
  // We use the val syntax and private in the constructor to create
  // member variables representing the leading and trailing elements
  // as well as private for information hiding:

  // CHANGE: change leading/trailing to vars:
  private var leading: List[T],
  private var trailing: List[T]
) extends Queue[T] {
  // mirror returns a queue with leading elements.
  //
  // In particular, if we have no leading elements we create a new
  // queue with its leading elements being the reverse of the trailing
  // elements and Nil as its trailing elements. If we do have leading
  // elements then we do nothing.
  //
  // We use private to hide this method from outside this class.

  // CHANGE: introduce vars so we only need to update leading and
  // trailing once:
  private def mirror() =
    if (leading.isEmpty) {
      while (!trailing.isEmpty) {
        leading = trailing.head :: leading
        trailing = trailing.tail
      }
    }

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

  // CHANGE: call mirror() for side-effect and return head.
  def head = {
    mirror()
    leading.head
  }

  // The tail of the queue is a new queue where the leading elements
  // are the tail of the mirror of this queue and its trailing elements
  // are the trailing elements of the mirror.

  // CHANGE: call mirror() for side-effect and return new queue.
  def tail = {
    mirror()
    new FasterQueue(leading.tail, trailing)
  }

  // enqueue create a new queue with the leading elements being the
  // leading elements of the new queue and the trailing elements being
  // a new list constructed by consing the new element x to the
  // trailing elements.
  def enqueue[U >: T](x: U) =
    new FasterQueue[U](leading, x :: trailing)

  // We add a toString method to print it out nicely:
  override def toString = {
    val xs = leading ::: trailing.reverse
    "Queue(" + xs.mkString(",") + ")"
  }

  def isEmpty: Boolean = leading.isEmpty && trailing.isEmpty
}
