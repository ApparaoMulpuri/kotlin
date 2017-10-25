// !WITH_NEW_INFERENCE

package bar

class Test {
    val foo: Int? = null
    fun foo(o: Test) = foo == null && o.foo == null // ERROR warning: o.test == null is always true

    fun bar(a: Test, b: Test) {
        if (a.foo != null) {
            useInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>b.foo<!><!><!>)
        }
        if (a.foo != null) {
            useInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>foo<!><!><!>)
        }
        if (this.foo != null) {
            useInt(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>foo<!><!>)
        }
        if (foo != null) {
            useInt(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>this.foo<!><!>)
        }
    }

    fun useInt(i: Int) = i
}