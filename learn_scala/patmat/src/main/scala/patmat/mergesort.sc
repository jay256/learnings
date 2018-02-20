object mergesort{
  def msort(xs:List[Int]): List[Int] = {
    val n = xs.length/2
    if(n==0) xs
    else{
      def merge(xs:List[Int], ys:List[Int])
      : List[Int] = (xs,ys) match{
        case (Nil,ys)=>ys
        case (xs,Nil)=>xs
        case (x :: xs1,y :: ys1)=>
          if(x<y) x :: merge(xs1,ys)
          else y :: merge(xs,ys1)
      }
      val(fst,scd) = xs splitAt(n)
      merge(msort(fst),msort(scd))
    }
  }
  val nums = List(1,2,3,4,2,3,214)
  msort(nums)

  val data = List("a","a","a","b","c","c","a")
}