// !DIAGNOSTICS: -NOTHING_TO_INLINE
// !WITH_NEW_INFERENCE

inline fun <T> foo(t1: T, t2: T) = t1 ?: t2

inline fun <T> bar(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>l<!><!>: (T) -> Unit): T = null!!

fun use() {
    var x: Int?
    x = 5
    // Write is AFTER
    <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>.hashCode()
    // x is nullable at the second argument
    foo(bar { x = null }, x!!)
}
