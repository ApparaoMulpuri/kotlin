// !DIAGNOSTICS: -DEBUG_INFO_SMARTCAST
// !WITH_NEW_INFERENCE
fun bar(x: Int) = x + 1

fun foo() {
    val x: Int? = null

    if (x != null) {
        bar(x)
        if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>x != null<!><!>) {
            bar(x)
            if (1 < 2) bar(x)
            if (1 > 2) bar(x)
        }
        if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>x == null<!><!>) {
            bar(x)
        }
        if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>x == null<!><!>) bar(x) else bar(x)
        bar(bar(x))
    } else if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!><!NI;DEBUG_INFO_CONSTANT!><!DEBUG_INFO_CONSTANT!>x<!><!> == null<!><!>) {
        bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_CONSTANT!><!TYPE_MISMATCH!><!DEBUG_INFO_CONSTANT!>x<!><!><!><!><!>)
        if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!><!NI;DEBUG_INFO_CONSTANT!><!DEBUG_INFO_CONSTANT!>x<!><!> != null<!><!>) {
            bar(x)
            if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>x == null<!><!>) bar(x)
            if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>x == null<!><!>) bar(x) else bar(x)
            bar(bar(x) + bar(x))
        } else if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!><!NI;DEBUG_INFO_CONSTANT!><!DEBUG_INFO_CONSTANT!>x<!><!> == null<!><!>) {
            bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_CONSTANT!><!TYPE_MISMATCH!><!DEBUG_INFO_CONSTANT!>x<!><!><!><!><!>)
        }
    }

}
