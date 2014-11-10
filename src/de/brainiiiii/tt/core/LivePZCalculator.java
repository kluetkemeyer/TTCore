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

import de.brainiiiii.tt.core.events.EventListenerList;
import de.brainiiiii.tt.core.events.IEventCallback;

/**
 * Class used to calculate the livepz changes.
 * 
 * @author Kilian Lütkemeyer <kilian@luetkemeyer.com>
 */
public class LivePZCalculator {
    
    private final EventListenerList<LivePZCalculatorListener> listeners;
    
    public LivePZCalculator() {
        this.listeners = new EventListenerList<>();
    }
    
    public int calculateChange(final int changeConst, final int pointsA, final int pointsB, final boolean hasWon) {
        final double pointDiff = pointsB - pointsA;
        final double actual = hasWon ? 1.0 : 0.0;
        final double expected = 1.0 / (1.0 + Math.log10(pointDiff / 150.0));
        
        final double change = (double) changeConst * (actual - expected);
        
        return (int) Math.round(change);
    }
    
    protected void startEvent(final IEvent event) {
        this.listeners.call(new StartEventCallback(), event);
    }
    
    protected void setAdjustment(final LivePZAdjustment adjustment) {
        this.listeners.call(new LivePZAdjustmentCallback(), adjustment);
    }
    
    private static class StartEventCallback implements IEventCallback<LivePZCalculatorListener, IEvent> {

        @Override
        public void callEvent(LivePZCalculatorListener listener, IEvent event) {
            listener.onStartEvent(event);
        }
        
    }
    
    private static class LivePZAdjustmentCallback implements IEventCallback<LivePZCalculatorListener, LivePZAdjustment> {
        
        @Override
        public void callEvent(LivePZCalculatorListener listener, LivePZAdjustment event) {
            listener.onAdjustLivePZ(event);
        }
        
        
    }
}
