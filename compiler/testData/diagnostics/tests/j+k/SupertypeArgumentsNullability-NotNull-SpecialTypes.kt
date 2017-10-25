// !CHECK_TYPE
// !WITH_NEW_INFERENCE
// FILE: A.java
public class A {}

// FILE: X.java
import org.jetbrains.annotations.NotNull;

public class X<T> {
    @NotNull T fooN() {return null;}
    void barN(@NotNull T a) {}
}

// FILE: Y.java
public class Y extends X<String> {

}

// FILE: test.kt

fun main() {
    checkSubtype<Any>(Y().fooN())
    Y().barN(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>);
}
