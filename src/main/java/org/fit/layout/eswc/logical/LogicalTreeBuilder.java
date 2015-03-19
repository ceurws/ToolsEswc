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
        return "FitLayout.Grouping";
    }

    @Override
    public String getName()
    {
        return "FitLayout grouping segmentation algorithm";
    }

    @Override
    public String getDescription()
    {
        return "A configurable bottom-up segmentation algorithm";
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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean setParam(String name, Object value)
    {
        return false;
    }

    @Override
    public Object getParam(String name)
    {
        return null;
    }

}
