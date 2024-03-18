package atilla.studentregister;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView txtFirstName, txtLastName, txtEmail, txtDegreeProgram;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        txtFirstName = itemView.findViewById(R.id.textFirstName);
        txtLastName = itemView.findViewById(R.id.textLastName);
        txtEmail = itemView.findViewById(R.id.textEmail);
        txtDegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
    }
}
