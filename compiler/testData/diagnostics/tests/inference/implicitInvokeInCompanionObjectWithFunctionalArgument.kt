// !CHECK_TYPE
// !DIAGNOSTICS: -UNUSED_PARAMETER, -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE

class TestClass {
    companion object {
        inline operator fun <T> invoke(task: () -> T) = task()
    }
}

fun test(s: String): String {
    val a = TestClass { "K" }
    a checkType { _<String>() }

    <!NI;UNREACHABLE_CODE!><!UNREACHABLE_CODE!>val b =<!><!> TestClass { return s }
    <!NI;UNREACHABLE_CODE!><!UNREACHABLE_CODE!>b checkType { <!NI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET!>_<!><!><Nothing>() }<!><!>
}