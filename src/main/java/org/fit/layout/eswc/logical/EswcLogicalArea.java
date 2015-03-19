/**
 * EswcLogicalArea.java
 *
 * Created on 19. 3. 2015, 13:48:01 by burgetr
 */
package org.fit.layout.eswc.logical;

import org.fit.layout.impl.DefaultLogicalArea;
import org.fit.layout.model.Tag;

/**
 * 
 * @author burgetr
 */
public class EswcLogicalArea extends DefaultLogicalArea
{
    private Tag mainTag;

    @Override
    public String toString()
    {
        return "(" + mainTag.getValue() + ") " + getText();
    }
    
}
