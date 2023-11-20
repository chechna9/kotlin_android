fun main(args:Array<String>) {
    val sub = {a:Double, b:Double -> a-b}
    val a = 1
    val b = 4

    val theSum = mathHelpers.add(a.toDouble(),b.toDouble())
    val theSub = sub(a.toDouble(),b.toDouble())

    println("La somme de $a et $b est : $theSum" )
    println("La soustraction de $a par $b est : $theSub" )

}