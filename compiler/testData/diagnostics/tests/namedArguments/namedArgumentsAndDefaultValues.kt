// !WITH_NEW_INFERENCE

fun foo(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>a<!><!> : Int = 1, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>b<!><!> : String = "abc") {
}

fun bar(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>x<!><!> : Int = 1, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>y<!><!> : Int = 1, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>z<!><!> : String) {
}

fun test() {
    foo()
    foo(2)
    foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
    foo(b = "")
    foo(1, "")
    foo(a = 2)
    foo(1, "", <!NI;TOO_MANY_ARGUMENTS!><!TOO_MANY_ARGUMENTS!>""<!><!>)

    bar(z = "")
    bar(<!NI;NO_VALUE_FOR_PARAMETER!><!NO_VALUE_FOR_PARAMETER!>)<!><!>
    bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!><!NI;NO_VALUE_FOR_PARAMETER!><!NO_VALUE_FOR_PARAMETER!>)<!><!>
    bar(1, 1, "")
    bar(1, 1, "")
    bar(1, z = "")
    bar(1, z = "", y = 2)
    bar(z = "", <!MIXING_NAMED_AND_POSITIONED_ARGUMENTS!>1<!>)
    bar(1, <!NI;NAMED_PARAMETER_NOT_FOUND!><!NAMED_PARAMETER_NOT_FOUND!>zz<!><!> = "",
           <!MIXING_NAMED_AND_POSITIONED_ARGUMENTS!><!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>zz<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>foo<!><!><!>
           <!NI;NO_VALUE_FOR_PARAMETER!><!NO_VALUE_FOR_PARAMETER!>)<!><!>
}