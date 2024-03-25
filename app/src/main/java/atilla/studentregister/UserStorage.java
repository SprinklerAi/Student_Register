package atilla.studentregister;

import android.content.Context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();

    private static UserStorage userStorage = null;


    private UserStorage() {
    }
    public static UserStorage getInstance() {
        if (userStorage == null) {
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public ArrayList<User> getUsers() {
        return users;
    }


    public void addUser(User user) {
        users.add(user);
    }

    public void saveUsers(Context context) {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Couldn't save users to a file");
        }
    }

    public void loadUsers(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Failed to load users");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Failed to load users");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Failed to load users");
            e.printStackTrace();
        }
    }

}



