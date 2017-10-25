// !WITH_NEW_INFERENCE

// FULL_JDK

import java.util.stream.Collectors
import java.util.stream.IntStream

fun main(args: Array<String>) {
    val xs = IntStream.<!NI;INTERFACE_STATIC_METHOD_CALL_FROM_JAVA6_TARGET!><!INTERFACE_STATIC_METHOD_CALL_FROM_JAVA6_TARGET!>range<!><!>(0, 10).mapToObj { it.toString() }
            .collect(<!NI;TYPE_MISMATCH!>Collectors.toList()<!>)
    xs[0]
}