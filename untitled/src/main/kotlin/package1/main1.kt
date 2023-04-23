package package1

import java.io.File
import kotlin.system.measureTimeMillis
import java.nio.ByteBuffer
import java.nio.channels.FileChannel

val filename = "/Users/anisham/Desktop/anish/untitled/src/main/kotlin/MOCK_DATA.csv"

fun allAtOnce() {
    val timeInMillis = measureTimeMillis {
        val content = File(filename).readText()
        // Process the content of the file here
    }

    println("Time required to read file: ${timeInMillis}ms")
}

fun lineByLine(){
    val timeInMillis = measureTimeMillis {
        File(filename).useLines { lines ->
            lines.forEach { line ->

            }
        }
    }
    println("Time required to read file: ${timeInMillis}ms")
}

fun blockByBlock(){

    val bufferSize = 1024 // set the buffer size here

    val timeInMillis = measureTimeMillis {
        val fileChannel = FileChannel.open(File(filename).toPath())
        val buffer = ByteBuffer.allocate(bufferSize)

        while (fileChannel.read(buffer) > 0) {
            buffer.flip()
            // Process the content of the buffer here

            buffer.clear()
        }

        fileChannel.close()
    }

    println("Time required to read file: ${timeInMillis}ms")

}