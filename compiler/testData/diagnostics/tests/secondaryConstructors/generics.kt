// !DIAGNOSTICS: -UNUSED_PARAMETER -UNREACHABLE_CODE
// !WITH_NEW_INFERENCE
open class B<T>(x: T, y: T) {
    constructor(x: T): this(x, x)
    constructor(): this(null!!, null!!)
}

class A0 : B<String?> {
    constructor()
    constructor(x: String): super(x)
    constructor(x: String, y: String): super(x, y)
}

class A1<R> : B<R> {
    constructor()
    constructor(x: R): super(x)
    constructor(x: R, y: R): super(x, y)
}

class A2<R> {
    constructor(t: R, i: Int) : this(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>i<!><!><!>, 1)
}
