// !WITH_NEW_INFERENCE

fun Any?.foo(my: My) = my === this

class My(val x: Any)

// my is nullable in brackets because Any?.foo has nullable receiver
fun foo(my: My?) = my?.x.foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>my<!><!><!>)