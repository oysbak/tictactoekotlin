package tictactoe

class Row(
    private val firstCell: Cell,
    private val secondCell: Cell,
    private val thirdCell: Cell) {

    fun areAllEqual(c: Mark): Boolean {
        return firstCell.mark == c && secondCell.mark == c && thirdCell.mark == c
    }
}
