// !CHECK_TYPE
// !WITH_NEW_INFERENCE

package n

import java.util.*

fun test() {
    val foo = arrayList("").map { it -> it.length }.fold(0, { x, y -> Math.max(x, y) })
    checkSubtype<Int>(foo)
    checkSubtype<String>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>foo<!><!><!>)
}

//from library
fun <T> arrayList(vararg <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>values<!><!>: T) : ArrayList<T> {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>

fun <T, R> Collection<T>.map(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>transform<!><!> : (T) -> R) : List<R> {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>

fun <T> Iterable<T>.fold(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>initial<!><!>: T, <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>operation<!><!>: (T, T) -> T): T {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>