// !WITH_NEW_INFERENCE

fun v(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>x<!><!> : Int, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>y<!><!> : String, vararg <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>f<!><!> : Long) {}
fun v1(vararg <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>f<!><!> :  (Int) -> Unit) {}

fun test() {
    v(1, "")
    v(1, "", 1)
    v(1, "", 1, 1, 1)
    v(1, "", 1, 1, 1)

    v1()
    v1({})
    v1({}, {})
    v1({}, <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!>, {})
    v1({}, {}, {<!NI;UNUSED_EXPRESSION!><!UNUSED_EXPRESSION!>it<!><!>})
    v1({}) <!NI;VARARG_OUTSIDE_PARENTHESES!><!VARARG_OUTSIDE_PARENTHESES!>{}<!><!>
    v1 <!NI;VARARG_OUTSIDE_PARENTHESES!><!VARARG_OUTSIDE_PARENTHESES!>{}<!><!>
}