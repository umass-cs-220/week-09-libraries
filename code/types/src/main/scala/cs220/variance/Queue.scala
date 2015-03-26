package cs220.variance

trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  def enqueue[U >: T](x: U): Queue[U]
  def isEmpty: Boolean
}

/** The Queue object provides an interface to our queue library that
  * separates the internal implementation from its interface.
  */
object Queue {
  /** The apply method allows us to easily construct a new Queue
    * object without knowing the internal implementation.
    */
  def apply[T](xs: T*): Queue[T] = new FasterQueue[T](xs.toList, Nil)
}
