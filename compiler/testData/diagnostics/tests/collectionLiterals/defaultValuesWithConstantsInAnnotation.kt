// !LANGUAGE: +ArrayLiteralsInAnnotations
// !WITH_NEW_INFERENCE

const val ONE = 1

annotation class Foo(
        val a: IntArray = [ONE],
        val b: IntArray = [ONE, 2, 3]
)

val TWO = 2

fun getOne() = ONE
fun getTwo() = TWO

annotation class Bar(
        val a: IntArray = <!NI;ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!><!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>[TWO]<!><!>,
        val b: IntArray = <!NI;ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!><!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>[1, TWO]<!><!>,
        val c: IntArray = <!NI;ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!><!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>[getOne(), getTwo()]<!><!>
)

annotation class Baz(
        val a: IntArray = [<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>],
        val b: IntArray = [1, <!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>, 2],
        val c: IntArray = <!NI;ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!><!ANNOTATION_PARAMETER_DEFAULT_VALUE_MUST_BE_CONSTANT!>[<!NI;NO_THIS!><!NO_THIS!>this<!><!>]<!><!>
)
