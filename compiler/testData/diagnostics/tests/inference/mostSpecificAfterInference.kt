// !CHECK_TYPE
// !WITH_NEW_INFERENCE

package i

//+JDK
import java.util.*

fun <T, R> Collection<T>.map1(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>f<!><!> : (T) -> R) : List<R> {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>
fun <T, R> <!NI;PLATFORM_CLASS_MAPPED_TO_KOTLIN!><!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.lang.Iterable<T><!><!>.map1(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>f<!><!> : (T) -> R) : List<R> {<!NI;NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!><!NO_RETURN_IN_FUNCTION_WITH_BLOCK_BODY!>}<!><!>

fun test(list: List<Int>) {
    val res = list.map1 { it }
    //check res is not of error type
    checkSubtype<String>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>res<!><!><!>)
}

fun <T> Collection<T>.foo() {}
fun <T> <!NI;PLATFORM_CLASS_MAPPED_TO_KOTLIN!><!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.lang.Iterable<T><!><!>.foo() {}

fun test1(list: List<Int>) {
    val res = list.foo()
    //check res is not of error type
    checkSubtype<String>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>res<!><!><!>)
}