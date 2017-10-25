// !CHECK_TYPE
// !WITH_NEW_INFERENCE

fun ifThen(x: Int?) {
    if (x!! == 0) {
        checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
    }
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}

fun ifElse(x: Int?) {
    if (x!! == 0) else {
        checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
    }
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}

fun ifThenElse(x: Int?) {
    if (x!! == 0) {
        checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
    } else {
        checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
    }
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}

fun ifIs(x: Int?, cond: Boolean) {
    if ((x is Int) == cond) {
        checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    }
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
}
