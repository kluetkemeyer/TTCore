/*
 * The MIT License
 *
 * Copyright 2014 Kilian Lütkemeyer <kilian@luetkemeyer.com>.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.brainiiiii.tt.core;

/**
 * A game result holding information, who won the game.
 *
 * @param <O> The opponent type.
 * @author Kilian Lütkemeyer <kilian@luetkemeyer.com>
 */
public class WinnerGameResult<O extends IOpponent> extends GameResult<O> {

    private Player winner;

    public WinnerGameResult() {
        super();
    }

    public WinnerGameResult(O opponentA, O opponentB) {
        super(opponentA, opponentB);
    }

    public WinnerGameResult(IIsOpponent<O> opponentA, O opponentB) {
        super(opponentA, opponentB);
    }

    public WinnerGameResult(O opponentA, IIsOpponent<O> opponentB) {
        super(opponentA, opponentB);
    }

    public WinnerGameResult(IIsOpponent<O> opponentA, IIsOpponent<O> opponentB) {
        super(opponentA, opponentB);
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    @Override
    public Player getWinner() {
        return this.winner;
    }

    @Override
    public GameResult<O> invertResult() {
        final WinnerGameResult inverted = new WinnerGameResult(this.opponents[1], this.opponents[0]);
        if (this.winner != null) {
            if (this.winner == Player.PLAYER_A) {
                inverted.winner = Player.PLAYER_B;
            } else {
                inverted.winner = Player.PLAYER_A;
            }
        }
        return inverted;
    }

    @Override
    public String getText() {
        if (this.winner != null) {
            switch (this.winner) {
                case PLAYER_A:
                    return "+";
                case PLAYER_B:
                    return "-";
            }
        }
        return "?:?";
    }
}
