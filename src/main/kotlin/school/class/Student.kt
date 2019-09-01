package school.`class`

import java.util.concurrent.ThreadLocalRandom

data class Student(val name: String = "Unknown ${ThreadLocalRandom.current().nextInt()}")