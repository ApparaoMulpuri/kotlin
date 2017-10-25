// !DIAGNOSTICS: -UNUSED_VARIABLE, -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

fun foo(i: Int) {}
fun foo(s: String) {}
fun <T> id(x: T): T = x
fun <T> baz(x: T, y: T): T = TODO()

fun test() {
    val x1: (Int) -> Unit = id(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>))
    val x2: (Int) -> Unit = baz(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>), ::foo)
    val x3: (Int) -> Unit = baz(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>), id(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>)))
    val x4: (String) -> Unit = baz(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>), id(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>)))
    val x5: (Double) -> Unit = baz(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!><!NONE_APPLICABLE!>foo<!><!>), id(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!><!NONE_APPLICABLE!>foo<!><!>)))


    id<(Int) -> Unit>(id(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>)))
    id(id<(Int) -> Unit>(::foo))
    baz<(Int) -> Unit>(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>), id(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>)))
    baz(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>), id(id<(Int) -> Unit>(::foo)))
    baz(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>), id<(Int) -> Unit>(id(::<!NI;DEBUG_INFO_MISSING_UNRESOLVED!>foo<!>)))
}