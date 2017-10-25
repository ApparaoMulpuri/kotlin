// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE
// FILE: J.java

import org.jetbrains.annotations.*;

public class J {
    @NotNull
    public static J staticNN;
    @Nullable
    public static J staticN;
}

// FILE: k.kt

fun test() {
    val n = J.staticN
    foo(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>n<!><!><!>)
    J.staticNN = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>n<!><!>
    if (n != null) {
        foo(<!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>n<!><!>)
        J.staticNN = <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>n<!><!>
    }

    val x: J? = null
    J.staticNN = <!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!>
    if (x != null) {
        J.staticNN = <!NI;DEBUG_INFO_SMARTCAST!><!DEBUG_INFO_SMARTCAST!>x<!><!>
    }
}

fun foo(j: J) {}