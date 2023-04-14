package com.example.mytraining;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import java.util.ArrayList;

public class AdaptadorEjercicio extends ArrayAdapter<Ejercicio> {
    FragmentActivity appCompatActivity;
    ArrayList<Ejercicio> listaEjercicios;
    public AdaptadorEjercicio(FragmentActivity context, ArrayList<Ejercicio> listaEjercicios) {
        super(context, R.layout.ejerciciolayout, listaEjercicios);
        appCompatActivity = context;
        this.listaEjercicios=listaEjercicios;
    }
    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LayoutInflater inflater =
                appCompatActivity.getLayoutInflater();
        View item = inflater.inflate(R.layout.ejerciciolayout, null);
        View itemSetted = setView(position,item);
        return(itemSetted);
    }
    public View setView(int position, View item){
        Ejercicio miEjercicio = listaEjercicios.get(position);

        TextView tituloEjercicioTextView = item.findViewById(R.id.tituloEjercicioTV);
        tituloEjercicioTextView.setText(miEjercicio.getNombreEjercicio());
        TextView descripcionEjercicioTextView = item.findViewById(R.id.textView3);
        descripcionEjercicioTextView.setText(miEjercicio.getDescripcionEjercicio());

        return(item);

    }
}
