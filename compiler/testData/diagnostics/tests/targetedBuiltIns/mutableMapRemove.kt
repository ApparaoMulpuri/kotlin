// !DIAGNOSTICS: -UNUSED_PARAMETER -PARAMETER_NAME_CHANGED_ON_OVERRIDE
// !WITH_NEW_INFERENCE
// FULL_JDK

class KotlinMap1<K, V> : java.util.AbstractMap<K, V>() {
    override val entries: MutableSet<MutableMap.MutableEntry<K, V>>
        get() = throw UnsupportedOperationException()

    override fun remove(x: K, y: V) = true
}

class KotlinMap2 : java.util.AbstractMap<String, Int>() {
    override val entries: MutableSet<MutableMap.MutableEntry<String, Int>>
        get() = throw UnsupportedOperationException()

    override fun remove(x: String, y: Int) = true
}

fun foo(x: MutableMap<String, Int>, y: java.util.HashMap<String, Int>, z: java.util.AbstractMap<String, Int>) {
    x.remove("", 1)
    x.remove("", <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
    x.remove("", <!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>)

    y.remove("", 1)
    y.remove("", <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
    y.remove("", <!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>)

    z.remove("", 1)
    z.remove("", <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
    z.remove("", null)
}
