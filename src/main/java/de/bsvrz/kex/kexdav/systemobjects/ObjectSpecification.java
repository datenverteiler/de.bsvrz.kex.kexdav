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

package de.bsvrz.kex.kexdav.systemobjects;

import de.bsvrz.dav.daf.main.config.DataModel;
import de.bsvrz.dav.daf.main.config.SystemObject;
import de.bsvrz.kex.kexdav.management.ManagerInterface;

/**
 * Interface, dass einen Suchparameter für ein eindeutiges Objekt definiert. Ein Objekt kann z.B. anhand der Id oder der Pid identifiziert werden.
 *
 * @author Kappich Systemberatung
 * @version $Revision$
 */
public abstract class ObjectSpecification {

	public abstract SystemObject getObject(DataModel dataModel);

	public abstract boolean matches(final SystemObject object);

	@Override
	public abstract int hashCode();

	@Override
	public abstract boolean equals(final Object obj);

	@Override
	public abstract String toString();

	public static ObjectSpecification create(final SystemObject systemObject, final ManagerInterface manager) {
		String pid = systemObject.getPid();
		if(pid.length() > 0) {
			return new PidSpecification(pid);
		}
		return new IdSpecification(systemObject.getId(), manager);
	}
}
