package atilla.studentregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> users;
    private Context context;

    public  UserListAdapter(Context context, ArrayList<User> users) {
        this.users = users;
        this.context = context;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_user, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
    holder.txtFirstName.setText(users.get(position).getFirstName());
    holder.txtLastName.setText(users.get(position).getLastName());
    holder.txtEmail.setText(users.get(position).getEmail());
    holder.txtDegreeProgram.setText(users.get(position).getDegreeProgram());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
