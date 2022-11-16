package tictactoe

import kotlin.math.abs

class TicTakToe {
    private val board = Board3x3()

    fun play() {
        //board.setUp(getInput())
        board.draw()
        val playerX = Player(Mark.X)
        val playerO = Player(Mark.O)
        var currentPlayer = playerX
        do {
            board.setPlayerMove(currentPlayer.requestMove(board.getAvailableSpots()))
            board.draw()
            analyze()
            currentPlayer = if (currentPlayer == playerX) playerO else playerX
        } while (!isFinished())
    }

    private fun analyze() {
        when {
            isImpossible() -> println("Impossible")
            isWinner(Mark.X) -> println("X wins")
            isWinner(Mark.O) -> println("O wins")
            isDraw() -> println("Draw")
            else -> println("Game not finished")
        }
    }

    private fun isFinished(): Boolean {
        if (isWinner(Mark.X) || isWinner(Mark.O)) {
            return true
        }
        for (cell in board.cells) {
            if (cell.mark == Mark.BLANK) {
                return false
            }
        }
        return true
    }

    private fun isDraw(): Boolean {
        return isFinished() && !isWinner(Mark.X) && !isWinner(Mark.O)
    }

    private fun isWinner(mark: Mark): Boolean {
        for (row in board.allThreeInARowCombinations()) {
            if (row.areAllEqual(mark)) {
                return true
            }
        }
        return false
    }

    private fun isImpossible(): Boolean {
        return isWinner(Mark.X) && isWinner(Mark.O)
                || abs(noOf(Mark.X) - noOf(Mark.O)) > 1
    }

    private fun noOf(mark: Mark): Int {
        return board.cells.count { it.mark == mark }
    }
}
