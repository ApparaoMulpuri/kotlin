// !WITH_NEW_INFERENCE

// FILE: A.java

public class A {
    public <T> A(T x, java.util.List<T> y) {}
}

// FILE: main.kt

fun test(x: List<Int>, y: List<String>) {
    A("", x) // inferred as Any!
    A("", y)

    A<String>("", <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)

    A<Any>("", x)
    A<String>("", y)
    A<CharSequence>("", y)
}
