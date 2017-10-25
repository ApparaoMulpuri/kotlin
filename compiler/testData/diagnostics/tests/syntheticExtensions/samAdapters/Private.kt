// !WITH_NEW_INFERENCE

// FILE: KotlinFile.kt
fun foo(javaClass: JavaClass) {
    javaClass.<!NI;INVISIBLE_MEMBER!><!INVISIBLE_MEMBER!>doSomething<!><!> <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>{ }<!><!><!>
}

// FILE: JavaClass.java
public class JavaClass {
    private void doSomething(Runnable runnable) { runnable.run(); }
}