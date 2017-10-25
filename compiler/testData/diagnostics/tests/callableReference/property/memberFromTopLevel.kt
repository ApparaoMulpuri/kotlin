// !CHECK_TYPE
// !WITH_NEW_INFERENCE

import kotlin.reflect.*

class A {
    val foo: Int = 42
    var bar: String = ""
}

fun test() {
    val p = A::foo

    checkSubtype<KProperty1<A, Int>>(p)
    checkSubtype<KMutableProperty1<A, Int>>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>p<!><!><!>)
    checkSubtype<Int>(p.get(A()))
    p.get(<!NI;NO_VALUE_FOR_PARAMETER!><!NO_VALUE_FOR_PARAMETER!>)<!><!>
    p.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>set<!><!>(A(), 239)

    val q = A::bar

    checkSubtype<KProperty1<A, String>>(q)
    checkSubtype<KMutableProperty1<A, String>>(q)
    checkSubtype<String>(q.get(A()))
    q.set(A(), "q")
}
