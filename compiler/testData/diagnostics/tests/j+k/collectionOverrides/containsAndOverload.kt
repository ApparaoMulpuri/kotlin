// !DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_VARIABLE -PARAMETER_NAME_CHANGED_ON_OVERRIDE
// !WITH_NEW_INFERENCE

// FILE: A.java
abstract public class A implements java.util.Collection<String> {
    public boolean contains(Object x) {return false;}
    public boolean contains(String x) {return false;}
}

// FILE: main.kt
abstract class <!NI;CONFLICTING_JVM_DECLARATIONS!><!CONFLICTING_JVM_DECLARATIONS!>KA<!><!> : A() {
    <!NI;CONFLICTING_JVM_DECLARATIONS!><!CONFLICTING_JVM_DECLARATIONS!>override fun contains(x: String)<!><!> = false
}

fun foo(a: A, ka: KA) {
    a.contains("")
    a.contains(<!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!>)
    "" in a
    <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!> in a

    ka.contains("")
    ka.contains(<!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!>)
    "" in ka
    <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!> in ka
}
