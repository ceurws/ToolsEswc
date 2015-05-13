package org.fit.layout.eswc;

public class Event
{
    /**
     * 
     */
    public int order;
    public String sname;
    
    public Event()
    {
        order = 1;
        sname = null;
    }
    
    public Event(int order, String sname)
    {
        this.order = order;
        if (this.order <= 0)
            this.order = 1;
        this.sname = sname;
    }

    @Override
    public String toString()
    {
        return "Event [order=" + order + ", sname=" + sname + "]";
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + order;
        result = prime * result + ((sname == null) ? 0 : sname.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Event other = (Event) obj;
        if (order != other.order) return false;
        if (sname == null)
        {
            if (other.sname != null) return false;
        }
        else if (!sname.equals(other.sname)) return false;
        return true;
    }

}