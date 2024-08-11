import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.example.your_app_name.R;

public class VendingMesinFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_vending_mesin, container, false);

        // Handle integrasi vending mesin di sini (e.g., menggunakan API khusus)
        return view;
    }
}
