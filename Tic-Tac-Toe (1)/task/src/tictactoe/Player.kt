package tictactoe

class Player(playerMark: Mark = Mark.X) {
    private val decidedMove = PlayerMove(-1, playerMark)

    fun requestMove(availableSpots: List<Int>): PlayerMove {
        var isApprovedMove = false
        while (!isApprovedMove) {
            print("Enter the coordinates: ")
            isApprovedMove = validateInput(readLine()!!, availableSpots)
        }
        return decidedMove
    }

    private fun validateInput(input: String, availableSpots: List<Int>): Boolean {
        val values = input.split(" ")
        for (value in values) {
            if (value.toIntOrNull() == null) {
                println("You should enter numbers!")
                return false
            }
            if (!"123".contains(value)) {
                println("Coordinates should be from 1 to 3!")
                return false
            }
        }
        val (x,y) = values.map { it.toInt() }
        decidedMove.index = Board3x3.convertCoordinatesToIndex(x, y)

        if (!availableSpots.contains(decidedMove.index)) {
            println("This cell is occupied! Choose another one!")
            return false
        }
        return true
    }
}