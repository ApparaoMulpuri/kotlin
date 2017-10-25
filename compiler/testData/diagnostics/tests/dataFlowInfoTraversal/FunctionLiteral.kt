// !WITH_NEW_INFERENCE

fun bar(x: Int) = x + 1

fun foo() {
    val x: Int? = null

    fun baz() = bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    fun quux() = if (x != null) bar(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>) else baz()
    fun quuux() = bar(if (x == null) 0 else <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}
