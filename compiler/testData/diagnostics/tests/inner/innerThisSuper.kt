// !WITH_NEW_INFERENCE

interface Trait {
    fun bar() = 42
}

class Outer : Trait {
    class Nested {
        val t = this<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>@Outer<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>bar<!><!>()
        val s = <!NI;DEBUG_INFO_MISSING_UNRESOLVED!><!DEBUG_INFO_MISSING_UNRESOLVED!>super<!><!><!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>@Outer<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>bar<!><!>()
        
        inner class NestedInner {
            val t = this<!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>@Outer<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>bar<!><!>()
            val s = <!NI;DEBUG_INFO_MISSING_UNRESOLVED!><!DEBUG_INFO_MISSING_UNRESOLVED!>super<!><!><!NI;UNRESOLVED_REFERENCE!><!UNRESOLVED_REFERENCE!>@Outer<!><!>.<!NI;DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!><!DEBUG_INFO_ELEMENT_WITH_ERROR_TYPE!>bar<!><!>()
        }
    }
    
    inner class Inner {
        val t = this@Outer.bar()
        val s = super@Outer.bar()
    }
}