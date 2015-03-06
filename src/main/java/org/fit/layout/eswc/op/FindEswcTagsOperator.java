/**
 * FindEswcTagsOperator.java
 *
 * Created on 5. 3. 2015, 22:59:23 by burgetr
 */
package org.fit.layout.eswc.op;

import org.fit.layout.impl.BaseOperator;
import org.fit.layout.model.Area;
import org.fit.layout.model.AreaTree;
import org.fit.layout.model.Rectangular;

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
    private FindEditorsOperator opEditors;
    
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
        
        final Rectangular bt = opTitles.getBounds();
        final Rectangular bp = opPairs.getBounds();
        Rectangular between = new Rectangular(0, bt.getY2()+1, 5000, bp.getY1() - 1);
        opEditors = new FindEditorsOperator(between);
        opEditors.apply(atree, root);
    }
    
}
