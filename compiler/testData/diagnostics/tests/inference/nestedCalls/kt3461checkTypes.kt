// !WITH_NEW_INFERENCE

//KT-3461 Nullable argument allowed where shouldn't be
package a

class F {
    fun p(): String? = null
}

fun foo(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>s<!><!>: String) {}

fun r(): Int? = null

fun test() {
    foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>F().p()<!><!><!>)
    foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>r()<!><!><!>)
}