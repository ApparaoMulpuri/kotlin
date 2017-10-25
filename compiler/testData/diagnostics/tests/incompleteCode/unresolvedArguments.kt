//!DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

fun <T> foo(i: Int, t: T) {}
fun <T> foo(s: String, t: T) {}

fun bar(i: Int) {}
fun bar(s: String) {}

fun test() {
    <!NI;OVERLOAD_RESOLUTION_AMBIGUITY!>foo<!>(<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>rrr<!><!>, 1)
    <!NI;OVERLOAD_RESOLUTION_AMBIGUITY!>bar<!>(<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>rrr<!><!>)
}
