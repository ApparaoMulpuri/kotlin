// !CHECK_TYPE
// !WITH_NEW_INFERENCE

import <!NI;PLATFORM_CLASS_MAPPED_TO_KOTLIN!><!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.lang.Comparable<!><!> as Comparable

fun f(c: <!NI;PLATFORM_CLASS_MAPPED_TO_KOTLIN!><!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>Comparable<*><!><!>) {
    checkSubtype<kotlin.Comparable<*>>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>c<!><!><!>)
    checkSubtype<<!NI;PLATFORM_CLASS_MAPPED_TO_KOTLIN!><!PLATFORM_CLASS_MAPPED_TO_KOTLIN!>java.lang.Comparable<*><!><!>>(c)
}