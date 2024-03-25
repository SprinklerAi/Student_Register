package atilla.studentregister;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddUserActivity extends AppCompatActivity {
    private EditText editFirstName;
    private EditText editLastName;
    private EditText editEmail;
    private RadioGroup radioDegreeProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_user);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        radioDegreeProgram = findViewById(R.id.radioDegreeProgram);

    }

    public void addUser(View view) {
        String firstName = editFirstName.getText().toString();
        String lastName = editLastName.getText().toString();
        String email = editEmail.getText().toString();
        String degreeProgram = selectedRadio();

        User user = new User(firstName, lastName, email, degreeProgram);
        UserStorage.getInstance().addUser(user);

        UserStorage.getInstance().saveUsers(this);

    }

    public String selectedRadio() {

        String degreeProgram = "";

        if (radioDegreeProgram.getCheckedRadioButtonId() == R.id.seRadioButton) {
            degreeProgram = "Software Engineering";
        } else if (radioDegreeProgram.getCheckedRadioButtonId() == R.id.imRadioButton) {
            degreeProgram = "Industrial Engineering";
        } else if (radioDegreeProgram.getCheckedRadioButtonId() == R.id.ceRadioButton) {
            degreeProgram = "Computational Engineering";
        } else if (radioDegreeProgram.getCheckedRadioButtonId() == R.id.eeRadioButton) {
            degreeProgram = "Electrical Engineering";
        }
        return degreeProgram;
    }
}