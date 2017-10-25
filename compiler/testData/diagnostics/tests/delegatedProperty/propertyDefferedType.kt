// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

import kotlin.reflect.KProperty

class B {
    val c by Delegate(<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>ag<!><!>)
}

class Delegate<T: Any>(val init: T) {
    operator fun getValue(t: Any?, p: KProperty<*>): Int = null!!
}
