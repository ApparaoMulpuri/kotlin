// !WITH_NEW_INFERENCE

// JAVAC_SKIP
// FILE: JavaClass.java
public class JavaClass {
    public void foo(? x) {}

    public void bar(? extends String y) { }
}

// FILE: main.kt
fun foo() {
    JavaClass().foo(Any())
    JavaClass().bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>Any()<!><!><!>)
    JavaClass().bar("")
}
