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
 * Factory for creating game results from string representations.
 * 
 * @author Kilian Lütkemeyer <kilian@luetkemeyer.com>
 */
public abstract class GameResultFactory {
   
    /**
     * The instance of the factory.
     */
    private final static GameResultFactory INSTANCE = new GameResultFactoryImpl();
    
    /**
     * Returns the instance of the factory.
     * 
     * @return The instance of the factory implementation.
     */
    public static GameResultFactory instance() {
        return INSTANCE;
    }
    
    /**
     * Returns the game result according to the given string.
     * 
     * @param <O> The type of opponents for this game result.
     * @param str The string to parse.
     * @return The resulting game result or null, if the given string does not
     * contain any valide game result information.
     */
    public abstract <O extends IOpponent> GameResult<O> factory(final String str);
    
    
    /**
     * Returns the game result according to the given string.
     * 
     * Additionaly the given opponents will be linked to the game result.
     * 
     * @param <O> The type of opponents for this game result.
     * @param str The string to parse.
     * @param opponentA The first opponent.
     * @param opponentB the second opponent.
     * @return The resulting game result or null, if the given string does not
     * contain any valide game result information.
     */
    public <O extends IOpponent> GameResult<O> factory(final String str, IIsOpponent<O> opponentA, IIsOpponent<O> opponentB) {
        final GameResult<O> result = this.factory(str);
        
        result.setOpponent(GameResult.Player.PLAYER_A, opponentA);
        result.setOpponent(GameResult.Player.PLAYER_B, opponentB);
        
        return result;
    }
}

class GameResultFactoryImpl extends GameResultFactory {
    
    @Override
    public <O extends IOpponent> GameResult<O> factory(final String str) {
        final byte[] byteCode = str.getBytes();
        if (byteCode[0] == '+') {
            final WinnerGameResult<O> result = new WinnerGameResult<>();
            result.setWinner(GameResult.Player.PLAYER_A);
            return result;
        } else if (byteCode[0] == '-') {
            final WinnerGameResult<O> result = new WinnerGameResult<>();
            result.setWinner(GameResult.Player.PLAYER_B);
            return result;
        }
        
        return null;
    }
}
