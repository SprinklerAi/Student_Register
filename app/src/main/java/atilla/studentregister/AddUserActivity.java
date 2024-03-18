package atilla.studentregister;

import android.annotation.SuppressLint;
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
    private String degreeProgram;

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
    }


    public void addUser(User user) {

        editFirstName.setText(user.getFirstName());
        editFirstName.setText(user.getLastName());
        editEmail.setText(user.getEmail());

        RadioGroup radioDegreeProgram = findViewById(R.id.radioDegreePropgram);

        if (radioDegreeProgram.getCheckedRadioButtonId() == R.id.seRadioButton) {
            degreeProgram = "Software Engineering";
        } else if (radioDegreeProgram.getCheckedRadioButtonId() == R.id.imRadioButton) {
            degreeProgram = "Computational Engineering";
        } else if (radioDegreeProgram.getCheckedRadioButtonId() == R.id.ceRadioButton) {
            degreeProgram = "Electrical Engineering";
        } else if (radioDegreeProgram.getCheckedRadioButtonId() == R.id.eeRadioButton) {
            degreeProgram = "Industrial Engineering";
        }
        String degreeProgram = user.setDegreeProgram();
    }
}