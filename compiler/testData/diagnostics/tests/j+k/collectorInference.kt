// !CHECK_TYPE
// !WITH_NEW_INFERENCE
// SKIP_TXT
// FULL_JDK

import java.util.stream.Collectors
import java.util.stream.Stream

fun test(a: Stream<String>) {
    a.collect(<!NI;TYPE_MISMATCH!>Collectors.toList()<!>) checkType { _<MutableList<String>>() }
    // actually the inferred type is platform
    a.collect(<!NI;TYPE_MISMATCH!>Collectors.toList()<!>) checkType { <!NI;UNRESOLVED_REFERENCE_WRONG_RECEIVER!><!NI;DEBUG_INFO_UNRESOLVED_WITH_TARGET!>_<!><!><List<String?>>() }
}

