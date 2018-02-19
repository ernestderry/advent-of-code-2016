package day1b;

public class Location {
 int x;
 int y;
 
    public Location(int x, int y) {
    	setLocation(x, y);
    }
    
    public void setLocation(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public int getX() {
    	return x;
    }

    public int getY() {
    	return y;
    }
    
    @Override
	public boolean equals(Object obj) {
    	
    	Location loc = (Location) obj;
    	
		return this.x == loc.getX() && this.y == loc.getY();
	}
 
    @Override
	public int hashCode(){
		return x*100000 + y;
	}
    
    @Override
    public String toString(){
    	return "("+x+", "+y+")";
    }
    
}
