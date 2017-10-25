// !WITH_NEW_INFERENCE

fun bar() {
    false and false
}

// See exception in KT-13421
fun foo() {
    42 and <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>false<!><!><!>
}