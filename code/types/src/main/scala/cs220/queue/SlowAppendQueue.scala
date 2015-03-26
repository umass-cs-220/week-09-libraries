package cs220.queue

/** A "slow" functional queue.
  *
  * This functional queue uses a functional [List] as its internal
  * implementation of a queue.
  *
  * i-clicker: Which of the methods defined in the queue below is
  * expensive? That is, which method takes time proportional to the
  * number of elements in the queue?
  *
  * A) head
  * B) tail
  * C) enqueue
  *
  * Why?
  */
class SlowAppendQueue[T](elems: List[T]) extends Queue[T] {
  def head = elems.head
  def tail = new SlowAppendQueue(elems.tail)
  def enqueue(x: T) = new SlowAppendQueue(elems ::: List(x))
}
