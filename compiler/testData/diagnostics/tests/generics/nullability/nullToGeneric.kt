// !DIAGNOSTICS: -UNUSED_PARAMETER,-UNUSED_VARIABLE
// !WITH_NEW_INFERENCE

fun <E> bar(x: E) {}

fun <T> foo(): T {
    val x1: T = <!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!>
    val x2: T? = null

    bar<T>(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>)
    bar<T?>(null)

    return <!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!>
}

fun <T> baz(): T? = null

fun <T> foobar(): T = <!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!>

class A<F> {
    fun xyz(x: F) {}

    fun foo(): F {
        val x1: F = <!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!>
        val x2: F? = null

        xyz(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>)
        bar<F?>(null)

        return <!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!>
    }

    fun baz(): F? = null

    fun foobar(): F = <!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!>
}
