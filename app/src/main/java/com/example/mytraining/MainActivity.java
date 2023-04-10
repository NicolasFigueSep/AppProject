package com.example.mytraining;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.mytraining.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    DataBaseHelper dataBaseHelper=new DataBaseHelper(this);
    private SQLiteDatabase db;
    ListView listViewEjercicios;
    private ArrayList<Ejercicio> listaEjercicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_exercise, R.id.navigation_my_profile, R.id.navigation_my_routines)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        llenaListaEjercicios();
        initAndSetAdapter();

    }
    public void pruebaBD(){
        MyDataBaseOpenHelper dbHelper = new MyDataBaseOpenHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String selectQuery = "SELECT * FROM mytable;";
        Cursor cursor = db.rawQuery(selectQuery, null);
        // realiza operaciones con el cursor
        cursor.close();
        db.close();

    }
    public void llenaListaEjercicios(){
        listaEjercicios = new ArrayList<Ejercicio>();
        listaEjercicios.add(new Ejercicio(1,"Elevaciones de hombros con mancuernas","Sostén una mancuerna en cada mano y levanta los hombros hacia las orejas, manteniendo los brazos rectos. Mantén la posición durante un segundo y luego baja los hombros lentamente.",
                "https://youtu.be/xeJjTRIYOIM",0.060));
        listaEjercicios.add(new Ejercicio(2,"Remo con barra","Mantén la espalda recta y levanta la barra hacia tu pecho, manteniendo los codos cerca del cuerpo. Baja la barra lentamente y repite el ejercicio.",
                "https://www.youtube.com/watch?v=G8l_8chR5BE",0.100));
        listaEjercicios.add(new Ejercicio(3,"Encogimientos de hombros con cable"," Agarra un cable con una polea baja en cada mano y tira de ellos hacia arriba hasta que tus hombros estén cerca de tus oídos. Mantén la posición durante un segundo y luego baja lentamente los cables.",
                "https://youtu.be/v7QczJNuWIg",0.060));
    }
    public void initAndSetAdapter(){
        AdaptadorEjercicio miAdaptadorEjercicio = new AdaptadorEjercicio(this,listaEjercicios);
        listViewEjercicios = findViewById(R.id.exercise_list);
        listViewEjercicios.setAdapter(miAdaptadorEjercicio);
    }

}