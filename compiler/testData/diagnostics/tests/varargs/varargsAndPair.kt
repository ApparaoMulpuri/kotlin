// !CHECK_TYPE
// !WITH_NEW_INFERENCE

fun <T: Any> foo(vararg <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>ts<!><!>: T): T? = null

class Pair<A>(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>a<!><!>: A)

fun test() {
    val v = foo(Pair(1))
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>v<!><!><!>) // check that it is not error type
}