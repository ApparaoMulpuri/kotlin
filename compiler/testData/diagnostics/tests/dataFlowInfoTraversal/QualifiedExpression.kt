// !WITH_NEW_INFERENCE

fun baz(x: Int): Int = x + 1

class A {
    fun bar(x: Int) = baz(x)
}

fun foo() {
    val x: Int? = null

    A().bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    if (x == null) return
    A().bar(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}
