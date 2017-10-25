// !WITH_NEW_INFERENCE

class A {
    val b = B()
}
class B
operator fun B.invoke(i: Int) = i

fun foo(i: Int) = i

fun test(a: A?) {
    a?.b(1) //should be no warning
    foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>a?.b(1)<!><!><!>) //no warning, only error
}
