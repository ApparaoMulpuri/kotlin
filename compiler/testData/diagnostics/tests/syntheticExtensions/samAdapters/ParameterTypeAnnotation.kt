// !WITH_NEW_INFERENCE

// FILE: KotlinFile.kt
fun foo(javaInterface: JavaInterface) {
    javaInterface.doIt(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>) <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!>{ }<!><!>
    javaInterface.doIt("", <!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>)
}

// FILE: JavaInterface.java
import org.jetbrains.annotations.*;

public interface JavaInterface {
    void doIt(@NotNull String s, @NotNull Runnable runnable);
}