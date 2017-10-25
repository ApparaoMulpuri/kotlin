// !CHECK_TYPE
// !WITH_NEW_INFERENCE

fun simpleDoWhile(x: Int?, y0: Int) {
    var y = y0
    do {
        checkSubtype<Int?>(x)
        y++
    } while (x!! == y)
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}

fun doWhileWithBreak(x: Int?, y0: Int) {
    var y = y0
    do {
        checkSubtype<Int?>(x)
        y++
        if (y > 0) break
    } while (x!! == y)
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
}
