// !DIAGNOSTICS: -UNUSED_VARIABLE
// !WITH_NEW_INFERENCE
// FILE: A.java

import java.util.*;

class A<T> {
    B b;
}

// FILE: B.java

import java.util.*;

class B {
    void bar(List<Double> x);
}

// FILE: Test.java

class Test {
    static class RawADerived extends A {}
    static A rawAField = null;
}


// FILE: main.kt

val strList: List<String> = null!!

fun main() {
    val rawB = Test.rawAField.b;
    // Raw(A).b is not erased because it have no type parameters
    var rawInner = rawB.bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH(\(Mutable\)List<Double!>!; List<String>)!>strList<!><!><!>)
}
