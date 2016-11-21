//val divide = (x: Int)=> 42/x
//divide(0)

val divide = new PartialFunction[Int,Int]{
  override def apply(x: Int) = 42/x
  override def isDefinedAt(x: Int): Boolean = x!= 0
}