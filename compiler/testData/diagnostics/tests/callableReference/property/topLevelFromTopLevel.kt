// !CHECK_TYPE
// !WITH_NEW_INFERENCE

import kotlin.reflect.*

var x: Int = 42
val y: String get() = "y"

fun testX() {
    val xx = ::x
    checkSubtype<KMutableProperty0<Int>>(xx)
    checkSubtype<KProperty0<Int>>(xx)
    checkSubtype<KMutableProperty<Int>>(xx)
    checkSubtype<KProperty<Int>>(xx)
    checkSubtype<KCallable<Int>>(xx)

    checkSubtype<String>(xx.name)
    checkSubtype<Int>(xx.get())
    xx.set(239)
}

fun testY() {
    val yy = ::y
    checkSubtype<KMutableProperty0<String>>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>yy<!><!><!>)
    checkSubtype<KProperty0<String>>(yy)
    checkSubtype<KMutableProperty<String>>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>yy<!><!><!>)
    checkSubtype<KProperty<String>>(yy)
    checkSubtype<KCallable<String>>(yy)

    checkSubtype<String>(yy.name)
    checkSubtype<String>(yy.get())
    yy.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>set<!><!>("yy")
}
