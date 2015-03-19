/**
 * LogicalTreeBuilder.java
 *
 * Created on 19. 3. 2015, 13:54:48 by burgetr
 */
package org.fit.layout.eswc.logical;

import org.fit.layout.impl.BaseLogicalTreeProvider;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.LogicalAreaTree;

/**
 * 
 * @author burgetr
 */
public class LogicalTreeBuilder extends BaseLogicalTreeProvider
{

    @Override
    public String getId()
    {
        return "CEUR.Logical";
    }

    @Override
    public String getName()
    {
        return "CEUR Logical Tree Builder";
    }

    @Override
    public String getDescription()
    {
        return "Logical structure builder for CEUR proceedings";
    }

    @Override
    public String[] getParamNames()
    {
        return new String[0];
    }

    @Override
    public ValueType[] getParamTypes()
    {
        return new ValueType[0];
    }

    @Override
    public LogicalAreaTree createLogicalTree(AreaTree areaTree)
    {
        return new EswcLogicalTree(areaTree); //TODO continue building
    }

}
