// !WITH_NEW_INFERENCE

val p1 = 1 - 1
val p2 = 1 - 1.toLong()
val p3 = 1 - 1.toByte()
val p4 = 1 - 1.toInt()
val p5 = 1 - 1.toShort()

fun fooInt(p: Int) = p
fun fooLong(p: Long) = p
fun fooByte(p: Byte) = p
fun fooShort(p: Short) = p

fun test() {
    fooInt(p1)
    fooInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p2<!><!><!>)
    fooInt(p3)
    fooInt(p4)
    fooInt(p5)

    fooLong(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p1<!><!><!>)
    fooLong(p2)
    fooLong(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p3<!><!><!>)
    fooLong(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p4<!><!><!>)
    fooLong(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p5<!><!><!>)

    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p1<!><!><!>)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p2<!><!><!>)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p3<!><!><!>)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p4<!><!><!>)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p5<!><!><!>)

    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p1<!><!><!>)
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p2<!><!><!>)
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p3<!><!><!>)
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p4<!><!><!>)
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p5<!><!><!>)
}