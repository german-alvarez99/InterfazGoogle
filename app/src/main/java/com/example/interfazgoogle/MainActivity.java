package com.example.interfazgoogle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navView;
    private DrawerLayout drawerLayout;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Buscar en drive");

        //agregar toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        //colocar botom de HOME
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //agregar el navegatin View
        navView = (NavigationView) findViewById(R.id.nav_view);
        navView.setNavigationItemSelectedListener(this);










        bottomNavigationView=(BottomNavigationView) findViewById(R.id.btnNavegation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.fragmentPriority){
                    showSelectedFragment(new fragmentPriority());
                }
                if(item.getItemId()==R.id.fragmentEspacios){
                    showSelectedFragment(new fragmentEspacios());
                }
                if(item.getItemId()==R.id.fragmentCompartidos){
                    showSelectedFragment(new fragmentCompartidos());
                }
                if(item.getItemId()==R.id.fragmentArchivos){
                    showSelectedFragment(new fragmentArchivos());
                }
                return true;
            }
        });
    }
    private void showSelectedFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
    }












    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_toolbar, menu);
        return true;
    }









    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        boolean fragmentTransaction = false;

        Fragment fragment = null;
        switch (menuItem.getItemId()) {
            case R.id.menu_reciente:
                fragment = new fragmentReciente();
                fragmentTransaction = true;
                break;
            case R.id.menu_destacado:
                fragment = new fragmentDestacados();
                fragmentTransaction = true;
                break;
            case R.id.menu_sinconexion:
                fragment = new fragmentSinConexion();
                fragmentTransaction = true;
                break;
            case R.id.menu_papelera:
                fragment = new fragmentPapelera();
                fragmentTransaction = true;
                break;
            case R.id.menu_notificaiones:
                fragment = new fragmentNotificaciones();
                fragmentTransaction = true;
                break;
            case R.id.menu_configuracion:
                fragment = new fragmentConfiguracion();
                fragmentTransaction = true;
                break;
            case R.id.menu_ayuda:
                fragment = new fragmentAyudaComentarios();
                fragmentTransaction = true;
                break;
        }

        if (fragmentTransaction) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, fragment)
                    .commit();

            menuItem.setChecked(true);
            getSupportActionBar().setTitle(menuItem.getTitle());
        }
        drawerLayout.closeDrawers();
        return false;
    }
}