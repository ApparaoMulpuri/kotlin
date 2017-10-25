// !DIAGNOSTICS: -DEBUG_INFO_SMARTCAST
// !WITH_NEW_INFERENCE
fun bar(x: Int): Int = x + 1

fun foo(): Int {
    val x: Int? = null

    bar(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
    if (x != null) return x
    
    val y: Int? = null
    if (y == null) return if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!><!NI;DEBUG_INFO_CONSTANT!><!DEBUG_INFO_CONSTANT!>y<!><!> != null<!><!>) y else <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_CONSTANT!><!TYPE_MISMATCH!><!DEBUG_INFO_CONSTANT!>y<!><!><!><!><!>
    
    val z: Int? = null
    if (z != null) return if (<!NI;SENSELESS_COMPARISON!><!SENSELESS_COMPARISON!>z == null<!><!>) z else z
    
    return <!NI;TYPE_MISMATCH!><!NI;DEBUG_INFO_CONSTANT!><!TYPE_MISMATCH!><!DEBUG_INFO_CONSTANT!>z<!><!><!><!>
}
