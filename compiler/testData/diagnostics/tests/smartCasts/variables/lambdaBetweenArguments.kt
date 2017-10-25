// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

fun foo(x: Int, f: () -> Unit, y: Int) {}

fun bar() {
    var x: Int?
    x = 4
    foo(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>, { x = null; x<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>hashCode() }, <!NI;SMARTCAST_IMPOSSIBLE!><!NI;SMARTCAST_IMPOSSIBLE!><!SMARTCAST_IMPOSSIBLE!>x<!><!><!>)
}