package cs220.queue

/** A "slow" functional queue.
  *
  * This functional queue uses a functional [List] as its internal
  * implementation of a queue.
  *
  * In this impementation we operate on the list in reverse
  * order. Unfortunately, this also makes certain methods expensive.
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
class SlowHeadQueue[T](elems: List[T]) extends Queue[T] {
  def head = elems.last
  def tail = new SlowHeadQueue(elems.init)
  def enqueue(x: T) = new SlowHeadQueue(x :: elems)
}
