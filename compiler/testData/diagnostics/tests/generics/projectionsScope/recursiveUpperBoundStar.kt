// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE
// See KT-7296
interface A<T>
interface B<T> : A<A<T>>

fun foo(x : B<*>) {
    bar1(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>) // this should not be valid
    bar2(x)
    bar3(x)
}

fun bar1(x : A<A<*>>) { }
fun bar2(x : A<out A<*>>) { }
fun bar3(x : A<*>) { }
