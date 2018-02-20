package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if (c==0 || c==r)
        1
      else
        pascal(c-1,r-1)+pascal(c,r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def f(chars: List[Char],numopens: Int ): Boolean={
        if(chars.isEmpty){
          numopens==0
        }else{
          val h = chars.head
          val n =
            if(h=='(') numopens + 1
            else if (h==')') numopens - 1
            else numopens
          if(n>=0) f(chars.tail,n)
          else false
        }
      }
      f(chars,0)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      val coinList = coins.sorted
      def f(money: Int, coins: List[Int]): Int = {
        if(coins.isEmpty)
          0
        else if(money - coins.head == 0 )
          1
        else if(money - coins.head < 0 )
          0
        else
          f(money-coins.head, coins) + f(money, coins.tail)
      }
      f(money, coinList)
    }
  }
