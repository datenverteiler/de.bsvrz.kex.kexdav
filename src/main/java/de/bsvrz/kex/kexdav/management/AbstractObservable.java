/*
 * Copyright 2011 by Kappich Systemberatung Aachen
 * 
 * This file is part of de.bsvrz.kex.kexdav.
 * 
 * de.bsvrz.kex.kexdav is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * de.bsvrz.kex.kexdav is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with de.bsvrz.kex.kexdav.  If not, see <http://www.gnu.org/licenses/>.

 * Contact Information:
 * Kappich Systemberatung
 * Martin-Luther-Straße 14
 * 52062 Aachen, Germany
 * phone: +49 241 4090 436 
 * mail: <info@kappich.de>
 */

package de.bsvrz.kex.kexdav.management;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Basis-Klasse, die Warnungen versendet
 *
 * @author Kappich Systemberatung
 * @version $Revision$
 */
public abstract class AbstractObservable implements Observable {

	private final Collection<KExDaVObserver> _observers = new CopyOnWriteArraySet<KExDaVObserver>();

	/**
	 * Veröffentlicht eine Warnung
	 * @param message Warnung
	 */
	public void addMessage(final Message message) {
		for(final KExDaVObserver observer : _observers) {
			observer.onNewWarning(this, message);
		}
	}

	public void addObserver(final KExDaVObserver observer) {
		_observers.add(observer);
	}

	public void removeObserver(final KExDaVObserver observer) {
		_observers.remove(observer);
	}
}
