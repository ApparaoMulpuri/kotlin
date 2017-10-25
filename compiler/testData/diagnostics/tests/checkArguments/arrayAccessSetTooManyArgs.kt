// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

class A {
    operator fun get(x: Int) {}
    operator fun set(x: String, value: Int) {}

    fun d(x: Int) {
        this["", <!TOO_MANY_ARGUMENTS!>1<!>] = <!NI;TOO_MANY_ARGUMENTS!>1<!>
    }
}
