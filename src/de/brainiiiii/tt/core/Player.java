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
public class Player {
    
    /**
     * The internal player id.
     * 
     * This id is dynamically generated within in the execution environment and
     * must provide a unique identifier among all players within this 
     * environment. Nevertheless is this id not a global unique player id, nor
     * a player specific id among different execution environments.
     */
    public int playerId;
    
    /**
     * The id of the player provided by TTLive.
     * 
     * This id is a global unique identifier used within the system to provide
     * a fast an save method to link players with events and game results.
     */
    public int ttliveId;
    
    /**
     * The title of the person.
     */
    public String title;
    
    /**
     * The firstname of the player.
     */
    public String firstname;
    
    /**
     * The lastname of the player.
     */
    public String lastname;
    
}
