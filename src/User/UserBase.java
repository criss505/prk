package User;

import java.util.ArrayList;
import java.util.List;

public class UserBase {
    private List<User> users = new ArrayList<User>();

    public UserBase() {
    }

    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }

//    find user by nameTag
    public User findUser(String nameTag){
        for (User user: users) {
            if (user.getNameTag().equals(nameTag)){
                return user;
            }
        }
        return null;
    }


}
