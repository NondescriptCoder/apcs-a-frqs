import java.util.List;
import java.util.ArrayList;
/**
 * A class that creates and stores information for climbing club members
 *
 * @Christopher Cameron
 * @v1
 */
public class ClimbingClub
{
 
    /** The list of climbs completed by members of the club.
     *  Guaranteed not to be null. Contains only non-null refrences.
     */
    private List<ClimbInfo> climbList;
    
    /** Creates a new ClimbingClub object
     */
    public ClimbingClub()
    {
        climbList = new ArrayList<ClimbInfo>();
    }  
    
    /** Adds a new climb with the name peakName and time climbTime to the list of climbs.
     *  @param peakName the name of the mountain peak climbed
     *  @param climbTime the number of minutes taken to complete the climb.
     */
    public void addClimb(String peakName, int climbTime)
    {
        ClimbInfo c = new ClimbInfo(peakName,climbTime);
        
        int i = 0;
        
        while (i < climbList.size() && c.getName().compareTo(climbList.get(i).getName()) > 0)
        {
            i++;
        }
        
        climbList.add(i,c);
        
    }
    
    /** @return the number of distinct names in the list of climbs
      */
    public int distinctPeakNames()
    {
        
        if(climbList.size() == 0)
        {
            return 0;
        }
        
        ClimbInfo currInfo = climbList.get(0);
        String prevName = currInfo.getName();
        String currName = null;
        int numNames = 1;
        
        for(int k = 1; k < climbList.size(); k++)
        {
            currInfo = climbList.get(k);
            currName = currInfo.getName();
            
            if(prevName.compareTo(currName) != 0)
            {
                numNames++;
                prevName = currName;
            }
            
        }
        
        return numNames;
    }
    
    /** Prints the names and climb times of every peak in the climbing club
     */
    public void printClimbs()
    {
        for (ClimbInfo c: climbList)
        {
            System.out.println(c.getName() + " " + c.getTime());
        }
    }
}
