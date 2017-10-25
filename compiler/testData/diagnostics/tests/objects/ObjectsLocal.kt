// !WITH_NEW_INFERENCE

package localObjects

object A {
    val x : Int = 0
}

open class Foo {
    fun foo() : Int = 1
}

fun test() {
    A.x
    val b = object : Foo() {
    }
    b.foo()

    <!NI;LOCAL_OBJECT_NOT_ALLOWED!><!LOCAL_OBJECT_NOT_ALLOWED!>object B<!><!> {
        fun foo() {}
    }
    B.foo()
}

val bb = <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>B<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>foo<!><!>()