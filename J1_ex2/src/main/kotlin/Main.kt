fun main(args: Array<String>) {
    val myArray: IntArray = intArrayOf(9, 5, 90, 78, 4, 3, 3, 2, 1, 1, 3)
    println("The array at the beginning :")
    for (e in myArray){
        print(e)
        print(" | ")
    }
//    sorting now
    val mySortedArray = sorter.ArraySorter().tri(myArray)
    println("\nThe sorted array :")
    for (e in mySortedArray){
        print(e)
        print(" | ")
    }

}