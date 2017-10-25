// !CHECK_TYPE
// !WITH_NEW_INFERENCE

fun f1(s: String?) {
    if (s!! == "");
    checkSubtype<String>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>)
}

fun f2(s: Number?) {
    if (s is Int);
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!><!>)
    if (s as Int == 42);
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>s<!><!>)
}

fun f3(s: Number?) {
    if (s is Int && s <!NI;USELESS_CAST!><!USELESS_CAST!>as Int<!><!> == 42);
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>s<!><!><!>)
}

fun f4(s: Int?) {
    var u = <!NI;INVALID_IF_AS_EXPRESSION!><!INVALID_IF_AS_EXPRESSION!>if<!><!> (s!! == 42);
    if (u == Unit) u = <!NI;INVALID_IF_AS_EXPRESSION!><!INVALID_IF_AS_EXPRESSION!>if<!><!> (s == 239);
    return u
}