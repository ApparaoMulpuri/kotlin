// !WITH_NEW_INFERENCE

// FULL_JDK

import java.util.function.Consumer

abstract class MyIt1<out T> : Iterator<T> {
    override fun forEachRemaining(x: Consumer<in T>) {}
}

abstract class MyIt2<out T> : Iterator<T> {
    <!NI;NOTHING_TO_OVERRIDE!><!NOTHING_TO_OVERRIDE!>override<!><!> fun forEachRemaining(x: Consumer<in T?>) {}
}

abstract class MyIt3<out T> : Iterator<T> {
    <!NI;NOTHING_TO_OVERRIDE!><!NOTHING_TO_OVERRIDE!>override<!><!> fun forEachRemaining(x: Consumer<in T>?) {}
}

abstract class MyIt4 : Iterator<String?> {
    override fun forEachRemaining(x: Consumer<in String?>) {}
}

abstract class MyIt5 : Iterator<String> {
    override fun forEachRemaining(x: Consumer<in String>) {}
}

abstract class MyIt6 : Iterator<String?> {
    <!NI;NOTHING_TO_OVERRIDE!><!NOTHING_TO_OVERRIDE!>override<!><!> fun forEachRemaining(x: Consumer<in String>) {}
}

abstract class MyIt7 : Iterator<String> {
    <!NI;NOTHING_TO_OVERRIDE!><!NOTHING_TO_OVERRIDE!>override<!><!> fun forEachRemaining(x: Consumer<in String?>) {}
}


fun foo(x: Iterator<String>, y: Iterator<String?>) {
    x.forEachRemaining(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>)

    x.forEachRemaining { it -> it.length }
    x.forEachRemaining { it -> it<!NI;UNNECESSARY_SAFE_CALL!><!UNNECESSARY_SAFE_CALL!>?.<!><!>length }
    y.forEachRemaining { it -> it<!NI;UNSAFE_CALL!><!UNSAFE_CALL!>.<!><!>length }
    y.forEachRemaining { it -> it?.length }
}
