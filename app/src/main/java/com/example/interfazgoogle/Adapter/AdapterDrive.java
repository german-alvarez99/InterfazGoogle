package com.example.interfazgoogle.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.interfazgoogle.Model.Drive;
import com.example.interfazgoogle.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterDrive extends RecyclerView.Adapter<AdapterDrive.ViewHolderDrive> {
    List<Drive> ltdrives = new ArrayList<Drive>();

    public AdapterDrive(List<Drive> ltdrives) {
        this.ltdrives = ltdrives;
    }

    @NonNull
    @Override
    public ViewHolderDrive onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_drive, null, false);
        return new ViewHolderDrive(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDrive holder, int position) {
        holder.nombre.setText(ltdrives.get(position).getNombre());
        holder.fecha.setText(ltdrives.get(position).getFecha());
        holder.imagenUsario.setImageResource(ltdrives.get(position).getUsuario());
        holder.imagenContenido.setImageResource(ltdrives.get(position).getArchivoImage());
        if(ltdrives.get(position).getTipo().toString().trim().equals("file"))
            holder.imagenTipo.setImageResource(R.drawable.file);
        if(ltdrives.get(position).getTipo().toString().trim().equals("video"))
            holder.imagenTipo.setImageResource(R.mipmap.ic_video);
    }

    @Override
    public int getItemCount() {
        return ltdrives.size();
    }

    public class ViewHolderDrive extends RecyclerView.ViewHolder {
        CircleImageView imagenUsario;
        ImageView imagenContenido, imagenTipo;
        TextView nombre, fecha;

        public ViewHolderDrive(@NonNull View itemView) {
            super(itemView);
            imagenUsario= itemView.findViewById(R.id.imgFoto);
            imagenTipo= itemView.findViewById(R.id.imageTipo);
            imagenContenido= itemView.findViewById(R.id.imageContenido);
            nombre= itemView.findViewById(R.id.txtnombreArchivo);
            fecha= itemView.findViewById(R.id.txtFecha);
        }
    }
}
