import java.util.ArrayList;

/**
 * Models a basic Organization's structure
 * An Organization has a name, one Leader,
 * and an undefined number of members.
 * @author Stephen_Wagstaff
 */
public class Org {

// Instance variables
    private String name;
    private Leader leader;
    private ArrayList <Member> members;

// Constructors

    /**
     * Default constructor
     */
    public Org(){
        this("",null,null);
    }

    /**
     * Constructor only specifying name
     * All other value are set to null
     * @param name
     */
    public Org(String name){
        this(name,null,null);
    }

    /**
     * Constructor only specifying name and leader
     * @param name for the organization
     * @param leader for the organization
     */
    public Org(String name, Leader leader){
        this(name, leader, null);
    }

    /**
     * Constructor that allows multiple members to be added
     * It will check the array and only the Member objects will
     * be added.
     * @param name for the organization
     * @param leader for the organization
     * @param members an Array of Member objects to be added
     *                initially to the organization
     */
    public Org(String name, Leader leader, Object[] members){
        this.setName(name);
        this.setLeader(leader);
        this.members = new ArrayList<>();
        if(members != null){
            for(Object member : members){
                if(member instanceof Member){ this.members.add((Member)member);}
            }
        }
    }

// Accessors and mutators

    /**
     * Getter for the name
     * @return name for the organization
     */
    public String getName() { return this.name; }

    /**
     * Setter for the name
     * @param A new name value
     */
    private void setName(String name) { this.name = name; }

    /**
     * Getter of the leader
     * @return a Leader object of the current leader
     */
    public Leader getLeader() { return this.leader; }

    /**
     * Sets a new leader
     * @param A Leader object for the new leader
     */
    private void setLeader(Leader leader) {
        this.leader = leader;
    }

    
} // Close Class
