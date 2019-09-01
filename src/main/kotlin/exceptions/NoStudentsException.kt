package exceptions

import java.lang.Exception

data class NoStudentsException(val msg:String): Exception(msg)