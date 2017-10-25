// !WITH_NEW_INFERENCE

package test

@BadAnnotation(<!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!>)
object SomeObject

val some = SomeObject

annotation class BadAnnotation(val s: String)