// !DIAGNOSTICS: -UNUSED_VARIABLE -UNUSED_PARAMETER -TOPLEVEL_TYPEALIASES_ONLY
// !WITH_NEW_INFERENCE

class C {
    typealias Self = C
    class Nested {
        class N2
        typealias Root = C
    }
    companion object X {
        val ok = "OK"
        class InCompanion
    }
}

val c = C.Self.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>Self<!><!>()
val n = C.Self.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>Nested<!><!>()
val x = C.Self.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>X<!><!>
val n2 = C.Nested.Root.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>Nested<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>N2<!><!>()
val ic = C.Self.<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>InCompanion<!><!>()
val ok = C.Self.ok
