// !WITH_NEW_INFERENCE

package test

// imports should be resolved
import test.topLevelFun
import test.topLevelProperty

@Deprecated("hidden", level = DeprecationLevel.HIDDEN)
fun topLevelFun(){}

@Deprecated("hidden", level = DeprecationLevel.HIDDEN)
var topLevelProperty = 1

@Deprecated("hidden", level = DeprecationLevel.HIDDEN)
fun String.topLevelExtensionFun(){}

@Deprecated("hidden", level = DeprecationLevel.HIDDEN)
val String.topLevelExtensionProperty: Int get() = 1

open class A {
    constructor(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>p<!><!>: Int) : this(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>) {}

    @Deprecated("hidden", level = DeprecationLevel.HIDDEN)
    constructor(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>s<!><!>: String){}

    @Deprecated("hidden", level = DeprecationLevel.HIDDEN)
    open fun memberFun(){}

    @Deprecated("hidden", level = DeprecationLevel.HIDDEN)
    val memberProperty = 1

    @Deprecated("hidden", level = DeprecationLevel.HIDDEN)
    fun String.memberExtensionFun(){}

    @Deprecated("hidden", level = DeprecationLevel.HIDDEN)
    val String.memberExtensionProperty: Int get() = 1

    fun foo() {
        <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>topLevelFun<!><!>()
        <!NI;UNRESOLVED_REFERENCE!><!NI;VARIABLE_EXPECTED!><!UNRESOLVED_REFERENCE!><!VARIABLE_EXPECTED!>topLevelProperty<!><!><!><!><!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>++<!><!>
        "".<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>topLevelExtensionFun<!><!>()
        "".<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>topLevelExtensionProperty<!><!>

        <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>memberFun<!><!>()
        <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>memberProperty<!><!>
        "".<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>memberExtensionFun<!><!>()
        "".<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>memberExtensionProperty<!><!>

        A(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
    }
}

interface I {
    @Deprecated("hidden", level = DeprecationLevel.HIDDEN)
    fun foo1()

    @Deprecated("hidden", level = DeprecationLevel.HIDDEN)
    fun foo2()
}

<!NI;ABSTRACT_MEMBER_NOT_IMPLEMENTED!><!ABSTRACT_MEMBER_NOT_IMPLEMENTED!>class X<!><!> : I {
    override fun foo1() {
    }
}

class B : A(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>) {
    // still can override it
    override fun memberFun() {
        super.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>memberFun<!><!>() // but cannot call super :)
    }
}

class C : A {
    constructor() : super(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
}