// !WITH_NEW_INFERENCE

annotation class AnnE(val i: MyEnum)

@AnnE(<!NI;ANNOTATION_PARAMETER_MUST_BE_ENUM_CONST!><!ANNOTATION_PARAMETER_MUST_BE_ENUM_CONST!>e<!><!>)
class Test

val e: MyEnum = MyEnum.A

enum class MyEnum {
    A
}

@AnnE(<!NI;TYPE_MISMATCH!><!NI;TYPE_MISMATCH!><!TYPE_MISMATCH!>Test()<!><!><!>)
class Test2