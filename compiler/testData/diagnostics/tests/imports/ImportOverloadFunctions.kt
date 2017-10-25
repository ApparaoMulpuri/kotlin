// !DIAGNOSTICS: -UNUSED_EXPRESSION -UNUSED_PARAMETER -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE
// FILE: 1.kt
package k

private fun zero() {}
private fun zero(a: Int) {}
private fun zero(a: String) {}

fun one() {}
private fun one(a: Int) {}
private fun one(a: String) {}

fun two() {}
fun two(a: Int) {}
private fun two(a: String) {}

fun all() {}
fun all(a: Int) {}
fun all(a: String) {}

// FILE: 2.kt

import k.<!NI;INVISIBLE_REFERENCE!><!NI;DEBUG_INFO_MISSING_UNRESOLVED!><!INVISIBLE_REFERENCE!><!DEBUG_INFO_MISSING_UNRESOLVED!>zero<!><!><!><!>
import k.one
import k.two
import k.all

fun test() {
    <!NI;INVISIBLE_MEMBER!><!INVISIBLE_MEMBER!>zero<!><!>()
    <!NI;INVISIBLE_MEMBER!><!INVISIBLE_MEMBER!>zero<!><!>(1)
    <!NI;INVISIBLE_MEMBER!><!INVISIBLE_MEMBER!>zero<!><!>("")

    one()
    one(<!NI;TOO_MANY_ARGUMENTS!><!TOO_MANY_ARGUMENTS!>1<!><!>)
    one(<!NI;TOO_MANY_ARGUMENTS!><!TOO_MANY_ARGUMENTS!>""<!><!>)

    two()
    two(1)
    two(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)

    all()
    all(1)
    all("")
}