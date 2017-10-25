// !WITH_NEW_INFERENCE

// FILE: A.java

import org.jetbrains.annotations.*;
import java.util.*;

class A<T> {
    @NotNull
    List<String> foo(@NotNull T x, @Nullable List<String> y) {}
}

// FILE: Test.java

class Test {
    static class DerivedRawA extends A {}

    static A rawField = null;
}

// FILE: main.kt

val doubleList: List<Double?> = null!!

fun main() {
    Test.rawField.foo("", doubleList)
    Test.rawField.foo(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>, doubleList)
    Test.DerivedRawA().foo(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>, doubleList)
}
