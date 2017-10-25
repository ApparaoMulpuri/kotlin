// !CHECK_TYPE
// !WITH_NEW_INFERENCE

//KT-1145 removing explicit generics on a call to Iterable<T>.map(...) seems to generate an odd bytecode/runtime error

package d

fun test(numbers: Iterable<Int>) {
    val s = numbers.map{it.toString()}.fold(""){it, it2 -> it + it2}
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!><!>)
}

//from library
fun <T, R> Iterable<T>.map(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>transform<!><!> : (T) -> R) : List<R> {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>

fun <T> Iterable<T>.fold(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>initial<!><!>: T, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>operation<!><!>: (T, T) -> T): T {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>