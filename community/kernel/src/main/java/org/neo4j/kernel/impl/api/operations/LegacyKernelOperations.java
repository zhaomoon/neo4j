/**
 * Copyright (c) 2002-2014 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.kernel.impl.api.operations;

import org.neo4j.graphdb.Direction;
import org.neo4j.kernel.api.Statement;
import org.neo4j.kernel.api.exceptions.EntityNotFoundException;
import org.neo4j.kernel.api.exceptions.RelationshipTypeIdNotFoundKernelException;
import org.neo4j.kernel.impl.api.KernelStatement;
import org.neo4j.kernel.impl.util.PrimitiveLongIterator;

/**
 * This is a temporary layer to make moving legacy components into the kernel API a two-step process, making the work
 * into smaller pieces. Things are added here first, but delegate to the old implementation. Once that is done, the
 * surface implementation can be changed, and then the old implementation can be moved properly into the kernel and
 * away from this intermediary step.
 */
public interface LegacyKernelOperations
{
    long nodeCreate( Statement state );

    long relationshipCreate( Statement state, long relationshipTypeId, long startNodeId, long endNodeId )
            throws RelationshipTypeIdNotFoundKernelException, EntityNotFoundException;

    PrimitiveLongIterator relationshipsGetFromNode( KernelStatement statement, long nodeId, Direction direction, int[] relTypes );

    PrimitiveLongIterator relationshipsGetFromNode( KernelStatement statement, long nodeId, Direction direction );
}