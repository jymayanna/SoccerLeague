package sl314.model;

/**
 * This domain object represents a soccer league.
 */
public class League {
    
	int objectID;
	int year;
    String season;
    String title;
    
    League(int objectID, int year, String season, String title) {
        this.objectID = objectID;
        this.year = year;
        this.season = season;
        this.title = title;
    }
    
    public int getYear() {
        return year;
    }
    public String getSeason() {
        return season;
    }
    public String getTitle() {
        return title;
    }
    
    // League entities are compared by their object IDs
    public boolean equals(Object o) {
        boolean result = false;
        if ( o instanceof League ) {
            League l = (League) o;
            result = (this.objectID == l.objectID);
        }
        return result;
    }
    
    // You need to override hashCode if you override equals
    public int hashCode() {
        Integer OID = new Integer(objectID);
        return OID.hashCode();
    }
    
    public String toString() {
        return title;
    }
}
