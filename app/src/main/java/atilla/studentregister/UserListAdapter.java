package atilla.studentregister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserListAdapter extends RecyclerView.Adapter<UserViewHolder> {
    private ArrayList<User> users = new ArrayList<>();
    private Context context;

    public  UserListAdapter(Context applicationContext, ArrayList<User> users) {
        this.context = context;
        this.users = users;
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
