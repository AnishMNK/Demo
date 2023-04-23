import package1.allAtOnce
import package1.blockByBlock
import package1.lineByLine
import java.io.File
import kotlin.system.measureTimeMillis



fun main(){
    lineByLine()
    allAtOnce()
    blockByBlock()
}


