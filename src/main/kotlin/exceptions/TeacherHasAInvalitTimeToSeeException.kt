package exceptions

import java.lang.Exception

data class TeacherHasAInvalitTimeToSeeException(val msg:String): Exception(msg)