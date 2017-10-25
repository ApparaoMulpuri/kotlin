// !WITH_NEW_INFERENCE

fun fooInt(p: Int) = p
fun fooLong(p: Long) = p
fun fooByte(p: Byte) = p
fun fooShort(p: Short) = p

fun test() {
    fooInt(-1)
    fooInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1111111111111111111<!><!><!>)
    fooInt(-1.toInt())
    fooInt(-1.toByte())
    fooInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toLong()<!><!><!>)
    fooInt(-1.toShort())

    fooByte(-1)
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1111111111111111111<!><!><!>)
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toInt()<!><!><!>)
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toByte()<!><!><!>)
    fooByte((-1).toByte())
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toLong()<!><!><!>)
    fooByte(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toShort()<!><!><!>)

    fooLong(-1)
    fooLong(-1111111111111111111)
    fooLong(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toInt()<!><!><!>)
    fooLong(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toByte()<!><!><!>)
    fooLong(-1.toLong())
    fooLong(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toShort()<!><!><!>)

    fooShort(-1)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1111111111111111111<!><!><!>)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toInt()<!><!><!>)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toByte()<!><!><!>)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toLong()<!><!><!>)
    fooShort(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1.toShort()<!><!><!>)
    fooShort((-1).toShort())
}