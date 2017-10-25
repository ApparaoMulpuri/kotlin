// !WITH_NEW_INFERENCE

//KT-2146 Nullability casts in when.
package kt2146

fun f1(s: Int?): Int {
    return when (s) {
        null -> 3
        else -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
    }
}

fun f2(s: Int?): Int {
    return when (s) {
        !is Int -> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!><!>
        else -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
    }
}

fun f3(s: Int?): Int {
    return when (s) {
        is Int -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
        else -> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!><!>
    }
}

fun f4(s: Int?): Int {
    return when {
        s == 4 -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
        s == null -> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_CONSTANT!><!TYPE_MISMATCH!><!DEBUG_INFO_CONSTANT!>s<!><!><!><!><!>
        else -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
    }
}

fun f5(s: Int?): Int {
    return when (s) {
        s -> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!><!>
        s!! -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
        s -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
        else -> 0
    }
}

fun f6(s: Int?): Int {
    return when {
        s is Int -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
        else -> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!><!>
    }
}

fun f7(s: Int?): Int {
    return when {
        s !is Int -> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!><!>
        else -> <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>
    }
}
