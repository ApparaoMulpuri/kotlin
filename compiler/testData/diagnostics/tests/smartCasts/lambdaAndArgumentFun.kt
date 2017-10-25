// !DIAGNOSTICS: -NOTHING_TO_INLINE
// !WITH_NEW_INFERENCE
// See KT-9143: smart cast on a variable nulled inside a lambda argument
inline fun <T> foo(t1: T, t2: T) = t1 ?: t2

inline fun <T> bar(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>l<!><!>: (T) -> Unit): T = null!!

fun use() {
    var x: Int?
    x = 5
    // Write to x is AFTER
    <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>.hashCode()
    // No smart cast should be here!
    foo(bar { x = null }, <!NI;SMARTCAST_IMPOSSIBLE!><!SMARTCAST_IMPOSSIBLE!>x<!><!>.hashCode())
}
