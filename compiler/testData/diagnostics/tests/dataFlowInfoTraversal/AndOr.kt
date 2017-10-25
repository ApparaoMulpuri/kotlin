// !DIAGNOSTICS: -DEBUG_INFO_SMARTCAST
// !WITH_NEW_INFERENCE
fun bar(x: Int): Int = x + 1

fun foo() {
    val x: Int? = null

    if (x != null && bar(x) == 0) bar(bar(x))
    bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    if (x == null || bar(x) == 0) bar(bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>))
    bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    if (x is Int && bar(x)*bar(x) == bar(x)) bar(x)
    bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
}
