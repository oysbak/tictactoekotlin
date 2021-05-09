package tictactoe

class Cell(val index: Int, var mark: Mark) {
    override fun toString(): String {
        return when (mark) {
            Mark.X -> "X"
            Mark.O -> "O"
            Mark.BLANK -> "_"
        }
    }

    companion object {
        fun valueOf(c: Char): Mark {
            return when (c) {
                'X' -> Mark.X
                'O' -> Mark.O
                else -> Mark.BLANK
            }
        }
    }
}