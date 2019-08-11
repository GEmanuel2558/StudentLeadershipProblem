package main

import constants.Constants.DEFAULT_VALUE
import exceptions.NoStudentsException
import exceptions.TeacherHasAInvalitTimeToSeeException
import game.PlayChooseTheLeader
import school.`class`.Student
import school.`class`.Teacher
import songs.Songs
import utils.DeveloperHelper
import utils.DeveloperHelper.isDebug
import java.util.stream.Collectors
import java.util.stream.IntStream

class MainTEST {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            //Prepare the game
            val game = PlayChooseTheLeader(
                Teacher(1L),
                IntStream.range(1, 6).mapToObj { Student("Student $it") }.collect(Collectors.toList())
            )
            //Store game answer
            val studentNameThatIsGoingToBeTheLeaderOfTheClass = try {
                //Start the game
                game.whoIsTheLeaderInTheClass(Songs.BeethovenSong())
            } catch (e: TeacherHasAInvalitTimeToSeeException) {
                //Check if the app is run in development mode
                if (isDebug) {
                    e.printStackTrace()
                }
                DEFAULT_VALUE
            } catch (e2: NoStudentsException) {
                //Check if the app is run in development mode
                if (isDebug) {
                    e2.printStackTrace()
                }
                DEFAULT_VALUE
            }
            //Display game answer
            println("The leader is $studentNameThatIsGoingToBeTheLeaderOfTheClass")
        }
    }
}