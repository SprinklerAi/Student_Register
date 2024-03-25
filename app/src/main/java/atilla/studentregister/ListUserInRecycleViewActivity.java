package atilla.studentregister;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;
import java.util.Comparator;

public class ListUserInRecycleViewActivity extends AppCompatActivity {

    private UserStorage userStorage;
    private RecyclerView rvUserView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setContentView(R.layout.activity_list_user);

        userStorage = UserStorage.getInstance();

        rvUserView = findViewById(R.id.rvUserView);

        rvUserView.setLayoutManager(new LinearLayoutManager(this));

        userStorage.getUsers().sort(new Comparator<User>() {
            @Override
            public int compare(User user1, User user2) {
                return user1.getLastName().compareTo(user2.getLastName());
            }
        });

        rvUserView.setAdapter(new UserListAdapter(getApplicationContext(),userStorage.getUsers()));

    }


}