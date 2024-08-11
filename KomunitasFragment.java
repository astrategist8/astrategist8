import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.your_app_name.R;

public class KomunitasFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_komunitas, container, false);

        // Handle integrasi komunitas di sini (e.g., menggunakan Firebase)
        return view;
    }
}
