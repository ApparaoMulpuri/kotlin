// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE

object A {
    operator fun set(x: Int, y: String = "y", z: Double) {
    }
}

object B {
    operator fun set(x: Int, y: String = "y", z: Double = 3.14, w: Char = 'w', v: Boolean) {
    }
}

object D {
    operator fun set(x: Int, vararg y: String, z: Double) {
    }
}

object Z {
    <!NI;INAPPLICABLE_OPERATOR_MODIFIER!><!INAPPLICABLE_OPERATOR_MODIFIER!>operator<!><!> fun set() {
    }
}

fun test() {
    A[0] = <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>
    A[0] = 2.72

    B[0] = <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>
    B[0] = <!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!NI;CONSTANT_EXPECTED_TYPE_MISMATCH!><!CONSTANT_EXPECTED_TYPE_MISMATCH!>2.72<!><!><!>
    B[0] = true

    D[0] = <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>
    D[0] = 2.72

    Z[<!NI;TOO_MANY_ARGUMENTS!><!TOO_MANY_ARGUMENTS!>0<!><!>] = <!NI;TOO_MANY_ARGUMENTS!><!TOO_MANY_ARGUMENTS!>""<!><!>
}
