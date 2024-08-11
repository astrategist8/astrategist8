import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.your_app_name.R;

public class NotifikasiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_notifikasi, container, false);

        // Handle notifikasi di sini (e.g., menggunakan NotificationCompat)
        return view;
    }
}
