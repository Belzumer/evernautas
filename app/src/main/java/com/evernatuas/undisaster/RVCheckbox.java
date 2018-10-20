package com.evernatuas.undisaster;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.evernatuas.undisaster.dto.Check;

import java.util.List;

public abstract class RVCheckbox extends RecyclerView.Adapter<RVCheckbox.CheckboxViewHolder>{

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

}
