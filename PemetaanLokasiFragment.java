import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.example.your_app_name.R;

public class PemetaanLokasiFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_pemetaan_lokasi, container, false);

        ListView listView = view.findViewById(R.id.list_lokasi);
        String[] lokasi = {"Lokasi 1", "Lokasi 2", "Lokasi 3"}; // Contoh data lokasi
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, lokasi);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Handle klik pada item listview, e.g., buka detail lokasi
            }
        });

        return view;
    }
}
