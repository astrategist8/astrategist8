import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.your_app_name.R;

public class KalkulatorPoinFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_kalkulator_poin, container, false);

        Spinner jenisKainSpinner = view.findViewById(R.id.jenis_kain);
        Spinner kondisiKainSpinner = view.findViewById(R.id.kondisi_kain);
        EditText beratKainEditText = view.findViewById(R.id.berat_kain);
        Button hitungPoinButton = view.findViewById(R.id.hitung_poin);
        TextView hasilPoinTextView = view.findViewById(R.id.hasil_poin);

        // Set data for spinners
        ArrayAdapter<CharSequence> jenisKainAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.jenis_kain_array, android.R.layout.simple_spinner_item);
        jenisKainAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jenisKainSpinner.setAdapter(jenisKainAdapter);

        ArrayAdapter<CharSequence> kondisiKainAdapter = ArrayAdapter.createFromResource(getContext(),
                R.array.kondisi_kain_array, android.R.layout.simple_spinner_item);
        kondisiKainAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        kondisiKainSpinner.setAdapter(kondisiKainAdapter);

        // Handle button click
        hitungPoinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil data dari input
                String jenisKain = jenisKainSpinner.getSelectedItem().toString();
                String kondisiKain = kondisiKainSpinner.getSelectedItem().toString();
                String beratKainStr = beratKainEditText.getText().toString();
                // ... hitung poin berdasarkan data

                // Tampilkan hasil
                hasilPoinTextView.setText("Poin: " + poin);
            }
        });

        return view;
    }
}
