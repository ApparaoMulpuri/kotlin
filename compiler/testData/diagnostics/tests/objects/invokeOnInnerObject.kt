// !WITH_NEW_INFERENCE

//no nested class access via instance reference error
fun test() {
    A.Companion.f(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
}

class A() {
    companion object {
        object f {
            operator fun invoke(i: Int) = i
        }
    }
}
