/**

Copyright (C) SYSTAP, LLC 2006-2011.  All rights reserved.

Contact:
     SYSTAP, LLC
     4501 Tower Road
     Greensboro, NC 27410
     licenses@bigdata.com

This program is free software; you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation; version 2 of the License.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
/*
 * Created on Nov 22, 2011
 */

package com.bigdata.rdf.sparql.ast.hints;

import com.bigdata.rdf.sparql.ast.ASTBase;
import com.bigdata.rdf.sparql.ast.eval.AST2BOpContext;
import com.bigdata.rdf.sparql.ast.optimizers.QueryHintScope;

/**
 * Interface for declaring query hints.
 * 
 * @param <T>
 *            The generic type of the value space for the query hint.
 *            
 * @author <a href="mailto:thompsonbry@users.sourceforge.net">Bryan Thompson</a>
 * @version $Id$
 */
public interface IQueryHint<T> {

    /**
     * The name of the query hint.
     */
    String getName();
    
    /**
     * The default value for this query hint (many query hints provide overrides
     * of defaults).
     */
    T getDefault();

    /**
     * Validate the value, returning an object of the appropriate type.
     * 
     * @param value
     *            The value.
     * 
     * @return The validated value.
     * 
     * @throws RuntimeException
     *             if the value can not be validated.
     */
    T validate(String value);

    /**
     * Attach/process the query hint.
     * 
     * @param ctx
     *            The query evaluation context.
     * @param scope
     *            The {@link QueryHintScope} specified for the query hint.
     * @param op
     *            An AST node to which the hint should bind.
     * @param value
     *            The value specified for the query hint.
     */
    void attach(AST2BOpContext ctx, QueryHintScope scope, ASTBase op, T value);

}