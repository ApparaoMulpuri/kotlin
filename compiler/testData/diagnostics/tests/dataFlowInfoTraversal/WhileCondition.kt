// !CHECK_TYPE
// !WITH_NEW_INFERENCE

fun simpleWhile(x: Int?, y0: Int) {
    var y = y0
    while (x!! == y) {
        checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
        y++
    }
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}

fun whileWithBreak(x: Int?, y0: Int) {
    var y = y0
    while (x!! == y) {
        checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
        break
    }
    checkSubtype<Int>(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>)
}

fun whileWithNoCondition(x: Int?) {
    while (<!NI;SYNTAX!><!><!SYNTAX!><!>) {
        x!!
    }
    checkSubtype<Int>(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
}
