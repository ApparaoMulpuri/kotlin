// !CHECK_TYPE
// !WITH_NEW_INFERENCE

package m

fun test(i: Int?) {
    if (i != null) {
        foo(l1@ <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>i<!><!>)
        foo((<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>i<!><!>))
        foo(l2@ (<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>i<!><!>))
        foo((l3@ <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>i<!><!>))
    }

    val a: Int = l4@ <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>
    val b: Int = (<!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!>)
    val c: Int = checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
    val d: Int = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>checkSubtype<Long>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)<!><!>


    foo(l4@ <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
    foo((<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>))
    foo(checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>))
    foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>checkSubtype<Long>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)<!><!><!>)
    
    use(a, b, c, d)
}

fun foo(i: Int) = i

fun use(vararg a: Any?) = a
