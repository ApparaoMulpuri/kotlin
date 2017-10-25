// !WITH_NEW_INFERENCE


class A {
    operator fun component1() = 1
    operator fun component2() = ""
}

class C {
    operator fun iterator(): Iterator<A> = null!!
}

fun test() {
    for ((x, _) in C()) {
        foo(x, <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>)
    }

    for ((_, y) in C()) {
        foo(<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>, y)
    }

    for ((_, _) in C()) {
        foo(<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>, <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>)
    }

    for ((_ : Int, _ : String) in C()) {
        foo(<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>, <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>)
    }

    for ((_ : String, _ : Int) in <!NI;COMPONENT_FUNCTION_RETURN_TYPE_MISMATCH!><!NI;COMPONENT_FUNCTION_RETURN_TYPE_MISMATCH!><!COMPONENT_FUNCTION_RETURN_TYPE_MISMATCH!><!COMPONENT_FUNCTION_RETURN_TYPE_MISMATCH!>C()<!><!><!><!>) {
        foo(<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>, <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>)
    }

    val (x, _) = A()
    val (_, y) = A()

    foo(x, y)
    foo(x, <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>)
    foo(<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!>, y)

    val (<!NI;REDECLARATION!><!REDECLARATION!>`_`<!><!>, z) = A()

    foo(<!NI;UNDERSCORE_USAGE_WITHOUT_BACKTICKS!><!UNDERSCORE_USAGE_WITHOUT_BACKTICKS!>_<!><!>, z)

    val (_, <!NI;NAME_SHADOWING!><!NI;REDECLARATION!><!NAME_SHADOWING!><!REDECLARATION!>`_`<!><!><!><!>) = A()

    foo(<!NI;UNDERSCORE_USAGE_WITHOUT_BACKTICKS!><!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!UNDERSCORE_USAGE_WITHOUT_BACKTICKS!><!TYPE_MISMATCH!>_<!><!><!><!><!>, y)

    val (<!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>unused<!><!>, _) = A()
}

fun foo(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>x<!><!>: Int, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>y<!><!>: String) {}
