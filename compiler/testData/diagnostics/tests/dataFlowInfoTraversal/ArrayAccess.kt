// !WITH_NEW_INFERENCE

fun bar(x: Int): Int = x + 1

fun foo() {
    val x: Int? = null
    val a = Array<Int>(3, {0})

    if (x != null) bar(a[<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>]) else bar(a[<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_CONSTANT!><!TYPE_MISMATCH!><!DEBUG_INFO_CONSTANT!>x<!><!><!><!><!>])
    bar(a[if (x == null) 0 else <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>])
    bar(a[<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>])
    
    "123"[<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>];
    if (x != null) "123"[<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>];
}
