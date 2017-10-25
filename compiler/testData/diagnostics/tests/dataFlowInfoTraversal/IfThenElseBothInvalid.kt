// !WITH_NEW_INFERENCE

fun bar(x: Int): Int = x + 1

fun foo() {
    val x: Int? = null

    bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    if (x != 2) {
        if (x == null) return
        2<!NI;OVERLOAD_RESOLUTION_AMBIGUITY!><!OVERLOAD_RESOLUTION_AMBIGUITY!>+<!><!><!NI;SYNTAX!><!><!SYNTAX!><!>
    }
    else {
        if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>x == null<!><!>) return
        2<!NI;OVERLOAD_RESOLUTION_AMBIGUITY!><!OVERLOAD_RESOLUTION_AMBIGUITY!>+<!><!><!NI;SYNTAX!><!><!SYNTAX!><!>
    }
    bar(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}
