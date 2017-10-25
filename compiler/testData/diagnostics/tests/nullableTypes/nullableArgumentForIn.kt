// !WITH_NEW_INFERENCE

fun test(x: Int?) {
     <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!> in 1..2
}