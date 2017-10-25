// !WITH_NEW_INFERENCE

open class Base {
    fun bar(x: Int): Int = x + 1
}

class Derived : Base() {
    fun baz(x: Int): Int = x + 1

    fun foo() {
        val x: Int? = null

        super.bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
        this.baz(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
        if (x == null) return
        super.bar(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
        this.baz(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)

        val y: Int? = null
        if (y != null) super.bar(this.baz(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>y<!><!>))
        else this.baz(super.bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_CONSTANT!><!TYPE_MISMATCH!><!DEBUG_INFO_CONSTANT!>y<!><!><!><!><!>))
    }
}
