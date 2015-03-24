package cs220.graphics

private [graphics] class Point(val x: Int, val y: Int)

// Obvious definition of a Rectangle:
class Rectangle01(
  private val topLeft: Point,
  private val bottomRight: Point) {

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // And many more methods
}

// We may want to represent graphical components
// more generically. We could do this with:
abstract class Component01 {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left

  // Other geometric methods...
}

// A better way would be to define a trait:
private [graphics] trait Rectangular {
  protected def topLeft: Point
  protected def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
}

// We could then mixin this trait:
private [graphics] abstract class Component extends Rectangular {
  // other methods
}

// The rectangle class can then be defined as:
private [graphics] class Rectangle (
  protected val topLeft: Point,
  protected val bottomRight: Point) extends Rectangular {
  // other methods for rectangles...
}

object Shapes {
  def point(x: Int, y: Int)      = new Point(x, y)
  def rect(p1: Point, p2: Point) = new Rectangle(p1, p2)
}


