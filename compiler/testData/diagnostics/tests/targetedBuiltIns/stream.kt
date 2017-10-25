// !WITH_NEW_INFERENCE

// FULL_JDK

import java.util.stream.*

interface A : Collection<String> {
    override fun stream(): Stream<String> = Stream.<!NI;INTERFACE_STATIC_METHOD_CALL_FROM_JAVA6_TARGET!><!INTERFACE_STATIC_METHOD_CALL_FROM_JAVA6_TARGET!>of<!><!>()
}

fun foo(x: List<String>, y: A) {
    x.stream().filter { it.length > 0 }.collect(<!NI;TYPE_MISMATCH!>Collectors.toList()<!>)
    y.stream().filter { it.length > 0 }
}
