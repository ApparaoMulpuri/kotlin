// !WITH_NEW_INFERENCE

//KT-1293 Kompiler doesn't show error when element of Array<Int?> is assigned to Int

package kt1293

fun main(args : Array<String>) {
    val intArray = arrayOfNulls<Int>(10)
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>i<!><!> : Int = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>intArray[0]<!><!>
    requiresInt(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>intArray[0]<!><!><!>)
}

fun requiresInt(<!NI;UNUSED_PARAMETER!><!UNUSED_PARAMETER!>i<!><!>: Int) {}
