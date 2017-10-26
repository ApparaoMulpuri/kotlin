// !DIAGNOSTICS: -UNUSED_PARAMETER, -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE

object TestClass {
    inline operator fun <T> invoke(task: () -> T) = task()
}

fun test(s: String): String {
    val a = TestClass { TestClass { TestClass } }
    a <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>checkType<!><!> { <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!><TestClass>() }

    <!NI;UNREACHABLE_CODE!><!UNREACHABLE_CODE!>val b =<!><!> TestClass { return s }
    <!NI;UNREACHABLE_CODE!><!UNREACHABLE_CODE!>b <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>checkType<!><!> { <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>_<!><!><Nothing>() }<!><!>
}