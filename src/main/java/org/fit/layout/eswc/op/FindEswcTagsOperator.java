/**
 * FindEswcTagsOperator.java
 *
 * Created on 5. 3. 2015, 22:59:23 by burgetr
 */
package org.fit.layout.eswc.op;

import org.fit.layout.impl.BaseOperator;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;

/**
 * This operator combines all the remaining operators for the ESWC tag assignment.
 * @author burgetr
 */
public class FindEswcTagsOperator extends BaseOperator
{
    private final String[] paramNames = {};
    private final ValueType[] paramTypes = {};

    private FindTitlesOperator opTitles;
    private FindPairsOperator opPairs;
    
    public FindEswcTagsOperator()
    {
        opTitles = new FindTitlesOperator();
        opPairs = new FindPairsOperator();
    }
    
    @Override
    public String getId()
    {
        return "Eswc.Tag.All";
    }
    
    @Override
    public String getName()
    {
        return "Find all ESWC tags";
    }

    @Override
    public String getDescription()
    {
        return "";
    }

    @Override
    public String[] getParamNames()
    {
        return paramNames;
    }

    @Override
    public ValueType[] getParamTypes()
    {
        return paramTypes;
    }

    //==============================================================================

    @Override
    public void apply(AreaTree atree)
    {
        apply(atree, atree.getRoot());
    }

    @Override
    public void apply(AreaTree atree, Area root)
    {
        opTitles.apply(atree, root);
        opPairs.apply(atree, root);
        System.out.println("TITLE: " + opTitles.getBounds());
        System.out.println("PAPERS: " + opPairs.getBounds());
    }
    
}
