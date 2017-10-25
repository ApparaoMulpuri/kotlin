// !DIAGNOSTICS: -UNUSED_PARAMETER
// !WITH_NEW_INFERENCE
open class B<R1, R2>(x: R1, y: R2)

class A0<T1, T2> {
    constructor(x: T1, y: T2): <!NI;CYCLIC_CONSTRUCTOR_DELEGATION_CALL!><!CYCLIC_CONSTRUCTOR_DELEGATION_CALL!>this<!><!>(x, y)

    constructor(x: T1, y: T2, z: T2): this(x, 1) // ok, delegates to constructor(x: T1, y: Int)

    constructor(x: T1, y: Int): this(x, <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>""<!><!><!>)
    constructor(x: T1): this(x, 1)
    constructor(x: T1, y: T2, z: String): this(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>y<!><!><!>, <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>x<!><!><!>)
}

class A1<T1, T2> : B<T1, T2> {
    constructor(x: T1, y: T2): super(x, y)
    constructor(x: T1, y: Int): super(x, <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH(T2; Int)!>y<!><!><!>)
    constructor(x: T1, y: T1, z: T1): super(x, <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH(T2; T1)!>y<!><!><!>)
}

class A2<T1, T2> : B<T1, Int> {
    constructor(x: T1, y: T2): super(x, <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH(Int; T2)!>y<!><!><!>)
    constructor(x: T1, y: Int): super(x, y)
    constructor(x: T1, y: T1, z: T1): super(x, <!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH(Int; T1)!>y<!><!><!>)
    constructor(x: T1, y: T2, z: String): super(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH(T1; T2)!>y<!><!><!>, 1)
}

