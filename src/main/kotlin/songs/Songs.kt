package songs

sealed class Songs(val songLength: Int) {

    class BeethovenSong(songLength: Int = 2) : Songs(songLength)
    class MozzartSong(songLength: Int = 15) : Songs(songLength)
    class RihannaSong(songLength: Int = 7) : Songs(songLength)

}