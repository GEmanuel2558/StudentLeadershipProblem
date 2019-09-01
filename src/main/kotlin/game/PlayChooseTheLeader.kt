package game

import constants.Constants.DEFAULT_VALUE
import exceptions.NoStudentsException
import exceptions.NullStudentException
import exceptions.TeacherHasAInvalitTimeToSeeException
import extensions.replaceByIndex
import school.`class`.Student
import school.`class`.Teacher
import songs.Songs
import utils.DeveloperHelper.isDebug
import java.util.concurrent.TimeUnit

typealias Students = List<Student?>

class PlayChooseTheLeader(private val teacher: Teacher, private var listOfStudents: Students) {

    @Throws(
        TeacherHasAInvalitTimeToSeeException::class,
        NoStudentsException::class,
        NullStudentException::class
    )
    fun whoIsTheLeaderInTheClass(whatSongToUse: Songs): String {
        //Treat error cases first
        if (-1L == teacher.howMatchTimeMustPassUntilTheTeacherSeeANewStudent) {
            TeacherHasAInvalitTimeToSeeException("Please imput a valid teacher!")
        }

        if (listOfStudents.isEmpty()) {
            NoStudentsException("The class has 0 students!")
        }

        if (listOfStudents.all { null == it }) {
            NullStudentException("We have all students null!")
        }

        if (1 == listOfStudents.size) {
            //I have only one student. So I will return back his name!
            return listOfStudents[0]!!.name
        }
        //Now I know for sure that I can play the game
        var studentPosition = 0
        val totalStudentsInTheClass = listOfStudents.size
        while (1L != listOfStudents.stream().filter { null != it }.count()) {
            for (timeToWait in 0 until whatSongToUse.songLength) {
                try {
                    TimeUnit.MILLISECONDS.sleep(teacher.howMatchTimeMustPassUntilTheTeacherSeeANewStudent)
                } catch (e: InterruptedException) {
                    if (isDebug) {
                        e.printStackTrace()
                    }
                    return DEFAULT_VALUE
                }
                // I need to move the teacher to a valid student position.
                // I will go until I find at least one student and not null. Because all null positions
                // are eliminated students
                do {
                    ++studentPosition
                    studentPosition %= totalStudentsInTheClass
                } while (null == listOfStudents[studentPosition])
            }

            listOfStudents = listOfStudents.replaceByIndex(studentPosition, null)
            //println("studentName ${studentPosition} and listOfStudents = ${listOfStudents[studentPosition]}")
            println("List contains: $listOfStudents")
        }
        return listOfStudents.firstOrNull { null != it }?.name ?: ""
    }

}