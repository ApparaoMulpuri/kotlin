// !CHECK_TYPE
// !WITH_NEW_INFERENCE

fun whileLoop(x: Int?) {
    outer@ while (x != 0) {
        while (x != 1) {
            if (x == 2) continue@outer
        }
        checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    }
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}

fun doWhileLoop(x: Int?) {
    outer@ while (x != 0) {
        do {
            if (x == 2) continue@outer
        } while (x == null)
        checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    }
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}

fun whileLoopContinueInnerOuter(x: Int?) {
    outer@ while (x != 0) {
        inner@ while (x != 1) {
            while (x != 2) {
                if (x == 3) continue@inner
            }
            checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
        }
        checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
    }
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}
