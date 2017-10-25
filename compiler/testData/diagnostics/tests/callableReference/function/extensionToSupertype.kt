// !CHECK_TYPE
// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

import kotlin.reflect.*

interface A
interface B : A

fun A.foo() {}

fun take(f: (A) -> Unit) {}
fun take(f: () -> Unit) {}

fun test() {
    B::foo checkType { _<KFunction1<B, Unit>>() }

    <!NI;OVERLOAD_RESOLUTION_AMBIGUITY!><!NONE_APPLICABLE!>take<!><!>(B::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>)
}
