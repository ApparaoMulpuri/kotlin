// !WITH_NEW_INFERENCE

// FILE: KotlinFile.kt
fun foo(javaClass: JavaClass<Int>): Int {
    val inner = javaClass.createInner<String>()
    return <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>inner.doSomething(<!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>1<!><!><!>, "") <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>{ }<!><!><!><!><!>
}

// FILE: JavaClass.java
public class JavaClass<T> {
    public <X> Inner<X> createInner() {
        return new Inner<X>();
    }

    public interface Inner<X>{
        public T doSomething(T t, X x, Runnable runnable);
    }
}
