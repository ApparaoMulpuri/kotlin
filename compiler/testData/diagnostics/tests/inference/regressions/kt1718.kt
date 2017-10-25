// !CHECK_TYPE
// !WITH_NEW_INFERENCE

//KT-1718 compiler error when not using temporary variable
package n

import java.util.ArrayList

fun test() {
    val list = arrayList("foo", "bar") + arrayList("cheese", "wine")
    checkSubtype<List<String>>(list)
    //check it's not an error type
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>list<!><!><!>)
}

//from library
fun <T> arrayList(vararg <!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>values<!><!>: T) : ArrayList<T> {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>
operator fun <T> Iterable<T>.plus(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>elements<!><!>: Iterable<T>): List<T> {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>