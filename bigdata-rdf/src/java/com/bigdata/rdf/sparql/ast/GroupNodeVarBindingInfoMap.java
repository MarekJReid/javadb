/**

Copyright (C) SYSTAP, LLC 2006-2015.  All rights reserved.

Contact:
     SYSTAP, LLC
     2501 Calvert ST NW #106
     Washington, DC 20008
     licenses@systap.com

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
 * Created on June 20, 2015
 */
package com.bigdata.rdf.sparql.ast;

import java.util.HashMap;
import java.util.Map;



/**
 * Map from nodes to their respective {@link GroupNodeVarBindingInfo} object,
 * including setup method.
 * 
 * @author <a href="mailto:ms@metaphacts.com">Michael Schmidt</a>
 * @version $Id$
 */
public class GroupNodeVarBindingInfoMap {
   
   private Map<IGroupMemberNode, GroupNodeVarBindingInfo> bindingInfo;
   
   /**
    * Constructor, setting up an object given a list of {@link IGroupMemberNode}
    * objects and the associated {@link StaticAnalysis} object as input.
    * 
    * @param nodes
    */
   public GroupNodeVarBindingInfoMap(
      final Iterable<IGroupMemberNode> nodes, final StaticAnalysis sa) {
      
      bindingInfo = new HashMap<IGroupMemberNode, GroupNodeVarBindingInfo>();
      for (IGroupMemberNode node : nodes) {
         
         final GroupNodeVarBindingInfo vbc = 
            new GroupNodeVarBindingInfo(node, sa);
         bindingInfo.put(node,vbc); 
         
      }
            
   }
   /**
    * Get the {@link GroupNodeVarBindingInfo} for the given node. Returns null
    * if the node is not registered.
    */
   public GroupNodeVarBindingInfo get(IGroupMemberNode node) {
      return bindingInfo.get(node);
   }

   
   
}
