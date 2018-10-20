package com.evernatuas.undisaster;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.evernatuas.undisaster.dto.Check;

import java.util.List;

public class RVCheckbox extends RecyclerView.Adapter<RVCheckbox.CheckboxViewHolder>{

    public static class CheckboxViewHolder extends RecyclerView.ViewHolder{

        CheckBox checkbox;
        Button boton;

        CheckboxViewHolder(View itemView) {
            super(itemView);

            checkbox = (CheckBox)itemView.findViewById(R.id.checkbox);
            boton = (Button)itemView.findViewById(R.id.botoneliminar);
        }
    }

    List<Check> checks;

    RVCheckbox(List<Check> checks){
        this.checks = checks;
    }

    @Override
    public int getItemCount() {
        return checks.size();
    }

    @Override
    public CheckboxViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_checkbox, viewGroup, false);
        CheckboxViewHolder cvh = new CheckboxViewHolder(v);
        return cvh;
    }

    @Override
    public void onBindViewHolder(CheckboxViewHolder cvh, int i) {
        //cvh.boton.setText(persons.get(i).name);
        //TODO: QUE EL BOTON ELIMINE
        cvh.checkbox.setChecked(checks.get(i).getSnMarcado());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}
