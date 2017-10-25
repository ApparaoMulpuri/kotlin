// !CHECK_TYPE
// !WITH_NEW_INFERENCE

interface Tr
interface G<T>

fun test(tr: Tr) = checkSubtype<<!NI;WRONG_NUMBER_OF_TYPE_ARGUMENTS!><!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>G<!><!>>(tr)