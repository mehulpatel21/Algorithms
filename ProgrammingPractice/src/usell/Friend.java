package usell;
/**
 * @author Mehul Patel
 * @Date 09/19/2017
 * @Description Implement canBeConnected() method that returns whether two friends of Friend class 
 * 				are connected or not. 
 */
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

public class Friend {
    
    private Collection<Friend> friends;
    private String email;

    public Friend(String email) {
        this.email = email;
        this.friends = new ArrayList<Friend>();
    }

    public String getEmail() {
        return email;
    }

    public Collection<Friend> getFriends() {
        return friends;
    }

    public void addFriendship(Friend friend) {
        friends.add(friend);
        friend.getFriends().add(this);
    }

    public boolean canBeConnected(Friend friend) {
        if(friends.contains(friend)){
            return true;
        } else if(!friend.friends.isEmpty()) {
            Iterator<Friend> itr = friend.friends.iterator();
            while(itr.hasNext()) {
                return canBeConnected(itr.next());
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        Friend a = new Friend("A");
        Friend b = new Friend("B");
        Friend c = new Friend("C");
        Friend d = new Friend("D");

        a.addFriendship(b);
        b.addFriendship(c);

        System.out.println(a.canBeConnected(d));
    }
}
