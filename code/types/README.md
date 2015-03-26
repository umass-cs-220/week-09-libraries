# Libraries and Type Parameterization

A good library defines an interface that is simple, easy to work with,
and uses the strengths of a language to help the client use the
library effectively. In Scala (and Java), types are an important
tool in creating effective libraries. This code example investigates
aspects of Scala's support for types that allow libraries to be
flexible and generic. In particular, using *type parameterization* and
*information hiding* together can lead to powerful library
abstractions that are reusable.

## Type Parameterization

Type parameterization allows you to write generic classes and
traits. Unlike Java, Scala requires that you specify a type. In Java,
you are allowed to drop the type parameter. For example, a `Set[T]`
defines a set of elements of type `T`. Thus, we can create sets of
strings, `Set[String]`, sets of integers, `Set[Int]`, but it must be a
set of *something*.

### Functional Queues

A functional queue is a queue data structure that is immutable. That
is, adding or removing elements from a queue does not modify the
queue's internal state, rather, it returns a new queue on add and
simply the first element on remove. How might we go about
implementation a library for a functional queue?

The operations the Queue abstraction must support are:

1. **head**: returns the first element of the queue.
1. **tail**: returns a new queue without its first element.
1. **enqueue**: return a new queue with a given element appended to
   the end.

[src/main/scala/cs220/queue/SlowAppendQueue.scala] is an example of a
functional queue. We use type parameterization to define a queue that
can be a queue of anything. However, there is a problem with this
queue implementation in that it is expensive to enqueue
elements. Ideally, we want to provide a functional queue that is as or
near efficient as its mutable counterpart. What can we do to fix this?

[src/main/scala/cs220/queue/SlowAppendQueue.scala]: src/main/scala/cs220/queue/SlowAppendQueue.scala

[src/main/scala/cs220/queue/SlowHeadQueue.scala] is another example of
a queue. We make changes to the internal representation of the queue
so that the enqueue operation is constant time. Unfortunately, this
impacts the other operations making both `head` and `tail` time
proportional to the number of elements in the queue. What can we do to
fix this problem?

[src/main/scala/cs220/queue/SlowHeadQueue.scala]:  src/main/scala/cs220/queue/SlowHeadQueue.scala

[src/main/scala/cs220/queue/FasterQueue.scala] is yet another example
that leverages the possibility that `head`, `tail`, and `enqueue` are
called with about the same frequency. In this example we can make a
good argument about its asymptotic behavior being constant time rather
than time proportional to the number of elements in the queue.

[src/main/scala/cs220/queue/FasterQueue.scala]: src/main/scala/cs220/queue/FasterQueue.scala

* What is this assumption?
* What happens when we break this assumption?
* What use case of this queue library causes the time complexity of
  one of its methods to become time proportional to the number of
  elements in the queue?

Although we used information hiding principles properly the above
implementations of queue resulted in libraries that were either
inefficient or relied upon assumptions about the use of that
library. In addition, we leaked aspects of its internal implementation
by requiring the client to provide *leading* and *trailing* elements
in its constructor. In designing effective and useful libraries it is
important to not only use the constructs of the language to provide a
sensible interface to a library, but also to not rely on assumptions
about its use.

### Information Hiding

The previous queue example used `private` vals in its constructor to
initialize the queue with *leading* and *trailing* lists. Clearly,
this is not a great design for a library. We would prefer a library
that would allow us to create a queue like this:

```scala
val q = Queue(1,2,3,4,5)
```

So, how could we design the queue library so that it takes advantage
of the Scala language to provide this interface? First, we must ensure
that we disallow the client from constructing a queue using `new`. To
do this we need to make sure that the constructor is private. This is
easily accomplished as you can see in the new version of
[src/main/scala/cs220/queue2/FasterQueue.scala]. In doing this the
client of the library is no longer capable of constructing a
`FasterQueue` object with `new`.

[src/main/scala/cs220/queue2/FasterQueue.scala]: src/main/scala/cs220/queue2/FasterQueue.scala

Next, we need to provide a library interface that allows us to create
a new `Queue` as shown in the above example. A sensible approach is to
use a *companion object* named `Queue` that implements the `apply`
method. You can see this extension in
[src/main/scala/cs220/queue2/Queue.scala].

[src/main/scala/cs220/queue2/Queue.scala]: src/main/scala/cs220/queue2/Queue.scala

With these two additions in place we have built a library with a
simple interface that behaves similiarly to the Scala standard
collections library and does not leak any internal implementation
details.

There are also other possible approaches to implementing this library
such as using internal classes, however, this approach is a simple and
flexible approach that accomplishes our goal.
