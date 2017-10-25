// !LANGUAGE: +SafeCastCheckBoundSmartCasts
// !WITH_NEW_INFERENCE
interface SomeClass {
    val data: Any?
}

interface SomeSubClass : SomeClass {
    val foo: Any?
}

object Impl : SomeSubClass {
    override val data = ""
    override val foo = 42
}

fun g(a: SomeClass?) {
    var b = <!NI;VARIABLE_WITH_REDUNDANT_INITIALIZER!><!VARIABLE_WITH_REDUNDANT_INITIALIZER!>(a as? SomeSubClass)?.foo<!><!>
    b = "Hello"
    if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>b != null<!><!>) {
        // 'a' cannot be cast to SomeSubClass!
        a<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>hashCode()
        a.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>foo<!><!>
        (a as? SomeSubClass)<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>foo
        (a as SomeSubClass).foo
    }
    var c = <!NI;VARIABLE_WITH_REDUNDANT_INITIALIZER!><!VARIABLE_WITH_REDUNDANT_INITIALIZER!>a as? SomeSubClass<!><!>
    c = Impl
    if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>c != null<!><!>) {
        // 'a' cannot be cast to SomeSubClass
        a<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>hashCode()
        a.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>foo<!><!>
        (a as? SomeSubClass)<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>foo
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>c<!><!>.hashCode()
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>c<!><!>.foo
    }
}

fun f(a: SomeClass?) {
    var aa = a

    if (aa as? SomeSubClass != null) {
        aa = null
        // 'aa' cannot be cast to SomeSubClass
        <!DEBUG_INFO_CONSTANT!>aa<!><!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>hashCode()
        aa.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>foo<!><!>
        (<!NI;DEBUG_INFO_CONSTANT!><!DEBUG_INFO_CONSTANT!>aa<!><!> as? SomeSubClass)<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>foo
        (<!NI;ALWAYS_NULL!><!ALWAYS_NULL!>aa<!><!> as SomeSubClass).foo
    }
    val b = (aa as? SomeSubClass)?.foo
    aa = null
    if (b != null) {
        // 'aa' cannot be cast to SomeSubClass
        <!DEBUG_INFO_CONSTANT!>aa<!><!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>hashCode()
        aa.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>foo<!><!>
        (<!NI;DEBUG_INFO_CONSTANT!><!DEBUG_INFO_CONSTANT!>aa<!><!> as? SomeSubClass)<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>foo
        (<!NI;ALWAYS_NULL!><!ALWAYS_NULL!>aa<!><!> as SomeSubClass).foo
    }
    aa = a
    val c = aa as? SomeSubClass
    if (c != null) {
        // 'c' can be cast to SomeSubClass
        aa<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>hashCode()
        aa.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>foo<!><!>
        (aa as? SomeSubClass)<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>foo
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>c<!><!>.hashCode()
        <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>c<!><!>.foo
    }
}