package tictactoe

class Board3x3 {
    var cells = arrayOf(
        Cell(0, Mark.BLANK), Cell(1, Mark.BLANK), Cell(2, Mark.BLANK),
        Cell(3, Mark.BLANK), Cell(4, Mark.BLANK), Cell(5, Mark.BLANK),
        Cell(6, Mark.BLANK), Cell(7, Mark.BLANK), Cell(8, Mark.BLANK)
    )

    fun draw() {
        println("---------")
        println("| ${cells[0]} ${cells[1]} ${cells[2]} |")
        println("| ${cells[3]} ${cells[4]} ${cells[5]} |")
        println("| ${cells[6]} ${cells[7]} ${cells[8]} |")
        println("---------")
    }

    fun setUp(input: String) {
        for (i in 0..8) {
            cells[i].mark = Cell.valueOf(input[i])
        }
    }

    fun getAvailableSpots(): List<Int> {
        val returns = mutableListOf<Int>()
        for (cell in cells) {
            if (cell.mark == Mark.BLANK) {
                returns.add(cell.index)
            }
        }
        return returns.toList()
    }

    fun setPlayerMove(playerMove: PlayerMove) {
        cells[playerMove.index].mark = playerMove.playerMark
    }

    fun allThreeInARowCombinations(): List<Row> = listOf(
        Row(cells[0], cells[1], cells[2]),
        Row(cells[3], cells[4], cells[5]),
        Row(cells[6], cells[7], cells[8]),
        Row(cells[0], cells[3], cells[6]),
        Row(cells[1], cells[4], cells[7]),
        Row(cells[2], cells[5], cells[8]),
        Row(cells[0], cells[4], cells[8]),
        Row(cells[2], cells[4], cells[6]),
    )

    companion object {
        fun convertCoordinatesToIndex(x: Int, y: Int): Int {
            return 3 * (x - 1) + (y - 1)
        }
    }
}
