package exceptions

import java.lang.Exception

data class NullStudentException(val msg:String): Exception(msg)