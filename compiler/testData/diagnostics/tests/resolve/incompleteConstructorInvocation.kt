// !WITH_NEW_INFERENCE

package p

class X<V>(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>provider<!><!>: () -> V, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>trackValue<!><!>: Boolean) {
}

class B {
    val c = <!NI;NO_VALUE_FOR_PARAMETER!><!NO_VALUE_FOR_PARAMETER!>X<!><!><String> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>{
        "e"
    }<!><!><!>
}
