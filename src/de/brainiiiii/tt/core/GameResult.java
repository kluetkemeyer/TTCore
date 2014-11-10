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
 * Abstract result for a single game.
 *
 * @param <O> The type of the opponent.
 * @author Kilian Lütkemeyer <kilian@luetkemeyer.com>
 */
public abstract class GameResult<O extends Opponent> implements IIsOpponent<O> {

    /**
     * Index types for a player.
     */
    public static enum Player {

        /**
         * The first player.
         */
        PLAYER_A,
        /**
         * The second player.
         */
        PLAYER_B;
    }

    /**
     * The list of opponents.
     */
    protected final IIsOpponent<O>[] opponents;

    /**
     * Creates a new game result, without opponents.
     */
    public GameResult() {
        this.opponents = new IIsOpponent[2];
    }

    /**
     * Creates a new game result with the given opponents.
     *
     * @param opponentA The first opponent.
     * @param opponentB The second opponent.
     */
    public GameResult(IIsOpponent<O> opponentA, IIsOpponent<O> opponentB) {
        this();

        this.setOpponent(Player.PLAYER_A, opponentA);
        this.setOpponent(Player.PLAYER_B, opponentB);
    }

    /**
     * Creates a new game result with the given opponents.
     *
     * @param opponentA The first opponent.
     * @param opponentB The second opponent.
     */
    public GameResult(O opponentA, IIsOpponent<O> opponentB) {
        this();

        this.setOpponent(Player.PLAYER_A, opponentA);
        this.setOpponent(Player.PLAYER_B, opponentB);
    }

    /**
     * Creates a new game result with the given opponents.
     *
     * @param opponentA The first opponent.
     * @param opponentB The second opponent.
     */
    public GameResult(IIsOpponent<O> opponentA, O opponentB) {
        this();

        this.setOpponent(Player.PLAYER_A, opponentA);
        this.setOpponent(Player.PLAYER_B, opponentB);
    }

    /**
     * Creates a new game result with the given opponents.
     *
     * @param opponentA The first opponent.
     * @param opponentB The second opponent.
     */
    public GameResult(O opponentA, O opponentB) {
        this();

        this.setOpponent(Player.PLAYER_A, opponentA);
        this.setOpponent(Player.PLAYER_B, opponentB);
    }

    /**
     * Sets one of the opponents.
     *
     * @param opponentIndex The index of the opponent, selecting which opponents
     * should be set.
     * @param opponent The opponent.
     */
    public final void setOpponent(int opponentIndex, IIsOpponent<O> opponent) {
        this.opponents[opponentIndex] = opponent;
    }

    /**
     * Sets one of the opponents.
     *
     * @param opponentIndex The index of the opponent, selecting which opponents
     * should be set.
     * @param opponent The opponent.
     */
    public final void setOpponent(int opponentIndex, O opponent) {
        this.setOpponent(opponentIndex, new IsOpponent<>(opponent));
    }

    /**
     * Sets one of the opponents.
     *
     * @param opponentIndex The index of the opponent, selecting which opponents
     * should be set.
     * @param opponent The opponent.
     */
    public final void setOpponent(Player opponentIndex, IIsOpponent<O> opponent) {
        this.setOpponent(opponentIndex.ordinal(), opponent);
    }

    /**
     * Sets one of the opponents.
     *
     * @param opponentIndex The index of the opponent, selecting which opponents
     * should be set.
     * @param opponent The opponent.
     */
    public final void setOpponent(Player opponentIndex, O opponent) {
        this.setOpponent(opponentIndex.ordinal(), opponent);
    }

    /**
     * Checks, whether the game is finished.
     * 
     * @return Returns <i>true</i>, if the game is finished already. Otherwise
     * <i>false</i> is returned.
     */
    public boolean isFinished() {
        return this.getWinner() != null;
    }

    /**
     * Returns the index of the player, who has won.
     * 
     * If no player has won yet, <i>null</i> will be returned.
     * 
     * @return The index of the player.
     */
    abstract public Player getWinner();

    /**
     * Returns true, if the first player has won.
     * 
     * @return <i>True</i> if the first opponent has won, otherwise 
     * <i>false</i>.
     */
    public final boolean hasWonA() {
        final Player winner = this.getWinner();
        return winner == Player.PLAYER_A;
    }

    /**
     * Returns true, if the second player has won.
     * 
     * @return <i>True</i> if the second opponent has won, otherwise 
     * <i>false</i>.
     */
    public boolean hasWonB() {
        final Player winner = this.getWinner();
        return winner == Player.PLAYER_B;
    }

    /**
     * Returns the winning opponent of this game.
     *
     * If no opponent has won this game, <i>null</i> will be returned, to
     * indicate the game is not finished yet.
     *
     * @return The winning opponent or <i>null</i>.
     */
    @Override
    public O getOpponent() {
        final Player winner = this.getWinner();
        if (winner == null) {
            return null;
        }

        switch (winner) {
            case PLAYER_A:
                return this.opponents[0].getOpponent();
            case PLAYER_B:
                return this.opponents[1].getOpponent();
        }
        return null;
    }

    /**
     * Returns the inverted result.
     * 
     * The inverted result, is the same result, just changed the opponents and
     * the result values.
     * 
     * @return The inverted result.
     */
    public abstract GameResult<O> invertResult();

    /**
     * Returns the display text.
     * 
     * @return The display text.
     */
    public abstract String getText();

    @Override
    public String toString() {
        return this.getText();
    }

}
