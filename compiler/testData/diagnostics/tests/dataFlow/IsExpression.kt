// !WITH_NEW_INFERENCE

fun f(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>a<!><!>: Boolean, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>b<!><!>: Int) {}

fun foo(a: Any) {
    f(a is Int, <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>a<!><!><!>)
    1 <!NI;NONE_APPLICABLE!><!NONE_APPLICABLE!>+<!><!> a
}