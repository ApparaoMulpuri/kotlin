// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

interface Foo
fun (Foo.() -> Unit).invoke(b : Foo.() -> Unit)  {}

object Z {
    infix fun add(b : Foo.() -> Unit) : Z = Z
}

val t2 = Z add <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>{ } <!NI;TOO_MANY_ARGUMENTS!><!TOO_MANY_ARGUMENTS!>{ }<!><!><!><!><!>
