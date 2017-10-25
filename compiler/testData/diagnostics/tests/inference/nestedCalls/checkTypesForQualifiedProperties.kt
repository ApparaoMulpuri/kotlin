// !WITH_NEW_INFERENCE

package a

fun test(c: C) {
    foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>c.b<!><!><!>)
}

fun foo(s: String) = s

class C(val b: Int) {}