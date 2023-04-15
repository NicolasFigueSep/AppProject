package com.example.mytraining.ui.exercise;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.mytraining.AdaptadorEjercicio;
import com.example.mytraining.Ejercicio;
import com.example.mytraining.R;
import com.example.mytraining.ReadDataBase;
import com.example.mytraining.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class ExerciseFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ListView listViewEjercicios;
    private ArrayList<Ejercicio> listaEjercicios;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ExerciseViewModel exerciseViewModel =
                new ViewModelProvider(this).get(ExerciseViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        exerciseViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        pruebaBD();
        initAndSetAdapter();
        return root;
    }

    @Override
    public void onDestroyView() {

        super.onDestroyView();
        //binding = null;
    }
    public void pruebaBD(){
        ReadDataBase prueba = new ReadDataBase(this.getContext());
        prueba.openDataBase();
        listaEjercicios = prueba.getAllExercise();
        prueba.closeDataBase();
        //PRUEBA Toast.makeText(this.getContext(), listaEjercicios.get(0).getIdEjercicio() + listaEjercicios.get(0).getNombreEjercicio() +" CALORIAS " + listaEjercicios.get(0).getCaloriasEjercicio(), Toast.LENGTH_SHORT).show();
    }
    public void initAndSetAdapter(){
        AdaptadorEjercicio miAdaptadorEjercicio = new AdaptadorEjercicio(this.getActivity(),listaEjercicios);
        listViewEjercicios = binding.getRoot().findViewById(R.id.exercise_list);
        listViewEjercicios.setAdapter(miAdaptadorEjercicio);
    }
}