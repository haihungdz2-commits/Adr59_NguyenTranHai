package vn.devpro.fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import vn.devpro.fragment.fragment.FragmentA;
import vn.devpro.fragment.fragment.FragmentB;
import vn.devpro.fragment.fragment.FragmentC;
import vn.devpro.fragment.fragment.FragmentD;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.bottomNavigation);

        loadFragment(new FragmentA());

        bottomNavigation.setOnItemSelectedListener(item -> {

            Fragment fragment = null;

            if (item.getItemId() == R.id.tabA) {
                fragment = new FragmentA();
            } else if (item.getItemId() == R.id.tabB) {
                fragment = new FragmentB();
            } else if (item.getItemId() == R.id.tabC) {
                fragment = new FragmentC();
            } else if (item.getItemId() == R.id.tabD) {
                fragment = new FragmentD();
            }

            if (fragment != null) {
                loadFragment(fragment);
            }

            return true;
        });
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}