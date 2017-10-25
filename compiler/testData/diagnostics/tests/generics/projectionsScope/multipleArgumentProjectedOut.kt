// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

class A<T> {
    fun foo(x: T, y: T) {}
}

fun test(a: A<out CharSequence>) {
    a.<!MEMBER_PROJECTED_OUT!>foo<!>(<!NI;TYPE_MISMATCH!>""<!>, <!NI;TYPE_MISMATCH!>""<!>)
}
