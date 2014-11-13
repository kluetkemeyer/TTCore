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
 *
 * @author Kilian Lütkemeyer <kilian@luetkemeyer.com>
 */
public abstract class TeamMatchSystem {
    
    public final static TeamMatchSystem WERNER_SCHEFFLER = new WernerSchefflerSystem();
    
    public final static TeamMatchSystem BUNDES_4 = new Bundes4System();
    
    public final static TeamMatchSystem PAARKREUZ_6 = new Paarkreuz6System();
    
    public final static TeamMatchSystem MOD_SWAYTHLING_CUP = new ModSwaythlingCupSystem();
    
    public final static TeamMatchSystem SWAYTHLING_CUP = new SwaythlingCupSystem();
    
    public static class MatchCombination {
        
        public final MatchType matchType;
        
        public final int opponentIndexA;
        
        public final int opponentIndexB;
        
        public MatchCombination(final MatchType mt, final int a, final int b) {
            this.matchType = mt;
            this.opponentIndexA = a;
            this.opponentIndexB = b;
        }
        
    }
    
    protected final MatchCombination[] combinations;
    
    private final int doubleCount;
    
    private final int singleCount;
    
    protected TeamMatchSystem(int matchCount, int doubleCount, int singleCount) {
        this.combinations = new MatchCombination[matchCount];
        
        this.doubleCount = doubleCount;
        this.singleCount = singleCount;
    }
    
    public int countMatches() {
        return this.combinations.length;
    }
    
    public MatchCombination getMatchCombination(int matchIndex) {
        assert(matchIndex >= 0);
        assert(matchIndex < this.combinations.length);
        
        return this.combinations[matchIndex];
    }
    
    public int getOpponentIndexA(int matchIndex) {
        return this.getMatchCombination(matchIndex).opponentIndexA;
    }
    
    public int getOpponentIndexB(int matchIndex) {
        return this.getMatchCombination(matchIndex).opponentIndexB;
    }
    
    public MatchType getMatchType(int matchIndex) {
        return this.getMatchCombination(matchIndex).matchType;
    }
    
    public int countDoubleOpponents() {
        return this.doubleCount;
    }
    
    public int countSingleOpponents() {
        return this.singleCount;
    }
    
    
}


class Bundes4System extends TeamMatchSystem {
    
    Bundes4System() {
        super(10, 2, 4);
        
        this.combinations[0] = new TeamMatchSystem.MatchCombination(MatchType.DOUBLE, 1, 1);
        this.combinations[1] = new TeamMatchSystem.MatchCombination(MatchType.DOUBLE, 2, 2);
        this.combinations[2] = new TeamMatchSystem.MatchCombination(MatchType.SINGLE, 1, 2);
        this.combinations[3] = new TeamMatchSystem.MatchCombination(MatchType.SINGLE, 2, 1);
        this.combinations[4] = new TeamMatchSystem.MatchCombination(MatchType.SINGLE, 3, 4);
        this.combinations[5] = new TeamMatchSystem.MatchCombination(MatchType.SINGLE, 4, 3);
        this.combinations[6] = new TeamMatchSystem.MatchCombination(MatchType.SINGLE, 1, 1);
        this.combinations[7] = new TeamMatchSystem.MatchCombination(MatchType.SINGLE, 2, 2);
        this.combinations[8] = new TeamMatchSystem.MatchCombination(MatchType.SINGLE, 3, 3);
        this.combinations[9] = new TeamMatchSystem.MatchCombination(MatchType.SINGLE, 4, 4);
    }
}


class WernerSchefflerSystem extends TeamMatchSystem {
    
    WernerSchefflerSystem() {
        super(14, 2, 4);
        
        this.combinations[0] = new MatchCombination(MatchType.DOUBLE, 1, 1);
        this.combinations[1] = new MatchCombination(MatchType.DOUBLE, 2, 2);
        this.combinations[2] = new MatchCombination(MatchType.SINGLE, 1, 2);
        this.combinations[3] = new MatchCombination(MatchType.SINGLE, 2, 1);
        this.combinations[4] = new MatchCombination(MatchType.SINGLE, 3, 4);
        this.combinations[5] = new MatchCombination(MatchType.SINGLE, 4, 3);
        this.combinations[6] = new MatchCombination(MatchType.SINGLE, 1, 1);
        this.combinations[7] = new MatchCombination(MatchType.SINGLE, 2, 2);
        this.combinations[8] = new MatchCombination(MatchType.SINGLE, 3, 3);
        this.combinations[9] = new MatchCombination(MatchType.SINGLE, 4, 4);
        this.combinations[10] = new MatchCombination(MatchType.SINGLE, 3, 1);
        this.combinations[11] = new MatchCombination(MatchType.SINGLE, 1, 3);
        this.combinations[12] = new MatchCombination(MatchType.SINGLE, 2, 4);
        this.combinations[13] = new MatchCombination(MatchType.SINGLE, 4, 2);
    }
}

class Paarkreuz6System extends TeamMatchSystem {
    
    Paarkreuz6System() {
        super(16, 3, 6);
        
        this.combinations[0] = new MatchCombination(MatchType.DOUBLE, 1, 2);
        this.combinations[1] = new MatchCombination(MatchType.DOUBLE, 2, 1);
        this.combinations[2] = new MatchCombination(MatchType.DOUBLE, 3, 3);
        this.combinations[3] = new MatchCombination(MatchType.SINGLE, 1, 2);
        this.combinations[4] = new MatchCombination(MatchType.SINGLE, 2, 1);
        this.combinations[5] = new MatchCombination(MatchType.SINGLE, 3, 4);
        this.combinations[6] = new MatchCombination(MatchType.SINGLE, 4, 3);
        this.combinations[7] = new MatchCombination(MatchType.SINGLE, 5, 6);
        this.combinations[8] = new MatchCombination(MatchType.SINGLE, 6, 5);
        this.combinations[9] = new MatchCombination(MatchType.SINGLE, 1, 1);
        this.combinations[10] = new MatchCombination(MatchType.SINGLE, 2, 2);
        this.combinations[11] = new MatchCombination(MatchType.SINGLE, 3, 3);
        this.combinations[12] = new MatchCombination(MatchType.SINGLE, 4, 4);
        this.combinations[13] = new MatchCombination(MatchType.SINGLE, 5, 5);
        this.combinations[14] = new MatchCombination(MatchType.SINGLE, 6, 6);
        this.combinations[15] = new MatchCombination(MatchType.DOUBLE, 1, 1);
    }
}

class ModSwaythlingCupSystem extends TeamMatchSystem {
    
    ModSwaythlingCupSystem() {
       super(7, 1, 3);
       
       this.combinations[0] = new MatchCombination(MatchType.SINGLE, 1, 2);
       this.combinations[1] = new MatchCombination(MatchType.SINGLE, 2, 1);
       this.combinations[2] = new MatchCombination(MatchType.SINGLE, 3, 3);
       this.combinations[3] = new MatchCombination(MatchType.DOUBLE, 1, 1);
       this.combinations[4] = new MatchCombination(MatchType.SINGLE, 1, 1);
       this.combinations[5] = new MatchCombination(MatchType.SINGLE, 3, 2);
       this.combinations[6] = new MatchCombination(MatchType.SINGLE, 2, 3);
    }
}

class SwaythlingCupSystem extends TeamMatchSystem {
    
    SwaythlingCupSystem() {
       super(9, 0, 3);
       
       this.combinations[0] = new MatchCombination(MatchType.SINGLE, 1, 1);
       this.combinations[1] = new MatchCombination(MatchType.SINGLE, 2, 2);
       this.combinations[2] = new MatchCombination(MatchType.SINGLE, 3, 3);
       this.combinations[3] = new MatchCombination(MatchType.SINGLE, 2, 1);
       this.combinations[4] = new MatchCombination(MatchType.SINGLE, 1, 3);
       this.combinations[5] = new MatchCombination(MatchType.SINGLE, 3, 2);
       this.combinations[6] = new MatchCombination(MatchType.SINGLE, 2, 3);
       this.combinations[7] = new MatchCombination(MatchType.SINGLE, 3, 1);
       this.combinations[8] = new MatchCombination(MatchType.SINGLE, 1, 2);
    }
}