// !DIAGNOSTICS: -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE

object Boo {}
class A {
    object Boo {}
}

fun foo() {
    val i1: Int = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>Boo<!><!>
    val i2: Int = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>A.Boo<!><!>
    useInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>Boo<!><!><!>)
    useInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>A.Boo<!><!><!>)
}
fun bar() {
    val i1: Int = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>Unit<!><!>
    useInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>Unit<!><!><!>)
}

fun useInt(i: Int) = i
