// !WITH_NEW_INFERENCE

object ObjectWithInvoke {
    operator fun invoke() = this
}

class ClassWithCompanionObjectWithInvoke {
    companion object {
        operator fun invoke(x: Any) = x
    }
}

typealias WI = ObjectWithInvoke

typealias CWI = ClassWithCompanionObjectWithInvoke

val test1 = WI()
val test2 = WI(<!NI;TOO_MANY_ARGUMENTS!><!TOO_MANY_ARGUMENTS!>null<!><!>)

val test3 = CWI()
val test4 = CWI("")
val test5 = CWI(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>)
val test5a = ClassWithCompanionObjectWithInvoke(<!NI;NULL_FOR_NONNULL_TYPE!><!NI;NULL_FOR_NONNULL_TYPE!><!NULL_FOR_NONNULL_TYPE!>null<!><!><!>)
