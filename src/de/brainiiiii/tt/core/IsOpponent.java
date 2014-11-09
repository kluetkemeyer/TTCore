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
 * Wrapper for any opponent.
 * 
 * A new wrapper for a opponent, to make him element of an opponent provider.
 * 
 * @param <O> The type of the opponent.
 * @author Kilian Lütkemeyer <kilian@luetkemeyer.com>
 */
public class IsOpponent<O> implements IIsOpponent<O> {
    
    /**
     * The opponent, to be wrapped.
     */
    private final O opponent;
    
    /**
     * Creates a new opponent wrapper.
     * 
     * @param opponent The opponent to be wrapped. 
     */
    public IsOpponent(final O opponent) {
        this.opponent = opponent;
    }
    
    
    @Override
    public O getOpponent() {
        return this.opponent;
    }
}
