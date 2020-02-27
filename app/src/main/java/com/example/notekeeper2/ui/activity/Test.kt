package com.example.notekeeper2.ui.activity

class Test {
    companion object {
        @JvmStatic fun main(args: Array<String>) {

            val a1 = arrayOf(1,2,3,4)
            val a2 = arrayOf(5,6,7,8)
            val a3 = arrayOf(0,0,0,0)

            val bigArray = arrayOf(a1, a2, a3)
            var outPutArray = arrayOfNulls<Array<Number?>>(a1.size)


            a1.forEachIndexed { index, i ->

                val smallArray = arrayOfNulls<Number>(bigArray.size)


                bigArray.forEachIndexed { index1, j ->
                    smallArray[index1] = j[index]
                }

                outPutArray.set(index, smallArray)

            }

            print(outPutArray.toString())

        }
    }
}