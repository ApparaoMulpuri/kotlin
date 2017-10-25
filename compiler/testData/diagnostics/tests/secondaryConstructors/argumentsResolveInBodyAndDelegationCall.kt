// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE
open class B(open val parentProp: Int)
val global: Int = 1
class A : B {
    val myProp: Int = 1
    override val parentProp = 1

    constructor(x: Int, y: Int = global): super(x + y + global) {
        foo(x, y, myProp)
        x + y + myProp + parentProp + super.parentProp
    }
    constructor(x: Double, y: Int): this(x.toInt() + y, x.toInt() * y) {
        foo(x.toInt(), y, myProp)
        x + y + myProp + parentProp + super.parentProp
    }
    constructor(x: String, y: Int): super(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>) {
        foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>, y, myProp)
        x + y + myProp + parentProp + super.parentProp
    }
    constructor(x: B, y: Int = <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>global2<!><!>): <!NI;NONE_APPLICABLE!><!NONE_APPLICABLE!>this<!><!>("", x) {
        x.parentProp + y + myProp + parentProp + super.parentProp
    }

    fun foo(x: Int, y: Int, z: Int) = x
}
