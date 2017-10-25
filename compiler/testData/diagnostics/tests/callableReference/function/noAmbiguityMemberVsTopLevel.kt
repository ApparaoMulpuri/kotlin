// !CHECK_TYPE
// !LANGUAGE: +CallableReferencesToClassMembersWithEmptyLHS
// !WITH_NEW_INFERENCE

import kotlin.reflect.KFunction0

fun expectFunction0Unit(f: () -> Unit) = f
fun expectFunction0String(f: () -> String) = f
fun expectFunction1Unit(f: (A) -> Unit) = f
fun expectFunction1String(f: (A) -> String) = f

fun foo(): String = ""

class A {
    fun foo() {}
    
    fun main() {
        val x = ::foo

        checkSubtype<KFunction0<Unit>>(x)

        expectFunction0Unit(x)
        expectFunction0String(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
        expectFunction1Unit(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
        expectFunction1String(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)

        expectFunction0Unit(::foo)
        expectFunction0String(::foo)
        expectFunction1Unit(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>::foo<!><!>)
        expectFunction1String(<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>::foo<!><!>)
    }
}
