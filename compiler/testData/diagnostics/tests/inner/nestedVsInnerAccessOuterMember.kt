// !WITH_NEW_INFERENCE

class Outer {
    fun function() = 42
    val property = ""
    
    class Nested {
        fun f() = <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>function<!><!>()
        fun g() = <!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>property<!><!>
        fun h() = this<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>@Outer<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>function<!><!>()
        fun i() = this<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>@Outer<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>property<!><!>
    }
    
    inner class Inner {
        fun innerFun() = function()
        val innerProp = property
        fun innerThisFun() = this@Outer.function()
        val innerThisProp = this@Outer.property
        
        inner class InnerInner {
            fun f() = innerFun()
            fun g() = innerProp
            fun h() = this@Inner.innerFun()
            fun i() = this@Inner.innerProp
        }
    }
}
