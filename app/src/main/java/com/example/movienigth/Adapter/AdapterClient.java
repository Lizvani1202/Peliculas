package com.example.movienigth.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.movienigth.Model.ModelClient;
import com.example.movienigth.R;

import java.util.List;

public class AdapterClient extends BaseAdapter {

    Context context;
    List<ModelClient>modelClients;

    public AdapterClient(Context context, List<ModelClient> modelClients) {
        this.context = context;
        this.modelClients = modelClients;
    }

    @Override
    public int getCount() {
        return modelClients.size();
    }

    @Override
    public Object getItem(int position) {
        return modelClients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ModelClient client = (ModelClient)getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.formato_lista_clientes,null);

        TextView tvNombre   = (TextView)convertView.findViewById(R.id.tvNombreCliente);
        TextView tvApellidp = (TextView)convertView.findViewById(R.id.tvApellidoCliente);
        TextView tvCedula   = (TextView)convertView.findViewById(R.id.tvCedulaCliente);
        TextView tvCorreo   = (TextView)convertView.findViewById(R.id.tvCorreoCliente);

        if(client.getStatus() == 1){
            tvNombre.setText(client.getFirst_name());
            tvApellidp.setText(client.getLast_name());
            tvCedula.setText(client.getCi());
            tvCorreo.setText(client.getEmail());
        }

        return convertView;
    }
}
