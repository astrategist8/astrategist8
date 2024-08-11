import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.example.your_app_name.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_pemetaan:
                    loadFragment(new PemetaanLokasiFragment());
                    return true;
                case R.id.navigation_edukasi:
                    loadFragment(new InformasiEdukasiFragment());
                    return true;
                case R.id.navigation_kalkulator:
                    loadFragment(new KalkulatorPoinFragment());
                    return true;
                case R.id.navigation_notifikasi:
                    loadFragment(new NotifikasiFragment());
                    return true;
                case R.id.navigation_komunitas:
                    loadFragment(new KomunitasFragment());
                    return true;
                case R.id.navigation_laporan:
                    loadFragment(new LaporanDampakFragment());
                    return true;
                case R.id.navigation_vending:
                    loadFragment(new VendingMesinFragment());
                    return true;
            }
            return false;
        });

        // Load default fragment
        loadFragment(new PemetaanLokasiFragment());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }
}
