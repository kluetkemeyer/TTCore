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
package de.brainiiiii.tt.core.events;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A list for listeners.
 * 
 * This listener list is implemented in a thread safe way to make multiple calls
 * on the same event list and editing on the eventlist while handling another
 * event possible.
 * 
 * @param <L> The type of the listener.
 * @author Kilian Lütkemeyer <kilian@luetkemeyer.com>
 */
public class EventListenerList<L> {
    
    /**
     * A simple object used for locking the list.
     */
    private final Object lock = new Object();
    
    /**
     * The list of listeners.
     */
    private List<L> listeners;
    
    /**
     * Creates a new blank listener list.
     */
    public EventListenerList() {
        this.clear();
    }
    
    /**
     * Creates a new listener list, containing all the listeners given by another
     * listener list.
     * 
     * @param reference The reference to copy all listeners from.
     */
    public EventListenerList(final EventListenerList<L> reference) {
        this.listeners = reference.copyListenerList();
    }
    
    /**
     * Removes all listeners from this list.
     */
    public final void clear() {
        synchronized(this.lock) {
            this.listeners = new ArrayList<>();
        }
    }
    
    /**
     * Adds a listener to the list.
     * 
     * @param listener The listener to add.
     */
    public void addListener(final L listener) {
        synchronized(this.lock) {
            this.listeners.add(listener);
        }
    }
    
    /**
     * Removes a listener from the list.
     * 
     * @param listener The listener to remove.
     */
    public void removeListener(final L listener) {
        synchronized(this.lock) {
            this.listeners.remove(listener);
        }
    }
    
    /**
     * Creates a copy of the list of listeners.
     * 
     * @return The copy of the list.
     */
    protected List<L> copyListenerList() {
        synchronized(this.lock) {
            return new ArrayList<L>(this.listeners);
        }
    }
    
    /**
     * Calls all listeners in this list.
     * 
     * This method runns the given event callback with every listener and the
     * given event once, to make the callback call the listener method on the
     * listener.
     * 
     * @param <E> The type of the event.
     * @param callback The callback handler.
     * @param event The event.
     */
    public <E> void call(final IEventCallback<L, E> callback, final E event) {
        final List<L> _listeners = this.copyListenerList();
        final Iterator<L> iterator = _listeners.iterator();
        while(iterator.hasNext()) {
            final L listener = iterator.next();
            
            callback.callEvent(listener, event);
        }
    }
}
