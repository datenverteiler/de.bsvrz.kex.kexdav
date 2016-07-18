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

package de.bsvrz.kex.kexdav.parameterloader;

import de.bsvrz.dav.daf.main.ClientDavInterface;
import de.bsvrz.dav.dav.util.accessControl.ObjectCollection;
import de.bsvrz.dav.dav.util.accessControl.ObjectCollectionParent;
import de.bsvrz.kex.kexdav.systemobjects.MissingObjectException;

/**
 * Interface für Klassen, die eine ObjectCollection erstellen.
 *
 * @author Kappich Systemberatung
 * @version $Revision$
 */
public interface ObjectCollectionFactory {

	/**
	 * Erstellt eine ObjectCollection aus dem Parameter
	 *
	 * @param objectCollectionParent Objektaustausch-Manager
	 * @param connection            Verbindung zum Datenverteiler
	 *
	 * @return Auswahl von Objekten
	 */
	ObjectCollection createObjectCollection(ObjectCollectionParent objectCollectionParent, ClientDavInterface connection) throws MissingObjectException;
}
