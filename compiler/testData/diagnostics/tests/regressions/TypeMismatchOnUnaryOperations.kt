// !WITH_NEW_INFERENCE

fun main(args : Array<String>) {
    val a : Int? = null;
    var v = 1
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>b<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>v<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>f<!><!> : String = <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>a<!><!><!>!!;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>g<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>v++<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>g1<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>++v<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>h<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>v--<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>h1<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>--v<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>i<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>!true<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>j<!><!> : String = foo@ <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>k<!><!> : String = foo@ bar@ <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>true<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>l<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>-1<!><!>;
    val <!NI;UNUSED_VARIABLE!><!UNUSED_VARIABLE!>m<!><!> : String = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>+1<!><!>;
}