package com.evernatuas.undisaster;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class DesastresActivity extends AppCompatActivity implements CaracteristicasDesastreFragment.OnFragmentInteractionListener,
        PlanesFragment.OnFragmentInteractionListener, ListaChecksFragment.OnFragmentInteractionListener {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager manager = getSupportFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.contenedorFragmentos, new CaracteristicasDesastreFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    transaction.replace(R.id.contenedorFragmentos, new ListaChecksFragment()).commit();

                    return true;
                case R.id.navigation_notifications:
                    transaction.replace(R.id.contenedorFragmentos, new PlanesFragment()).commit();

                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desastres);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.contenedorFragmentos, new CaracteristicasDesastreFragment()).commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }


}
