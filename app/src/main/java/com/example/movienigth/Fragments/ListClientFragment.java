package com.example.movienigth.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.movienigth.Adapter.AdapterClient;
import com.example.movienigth.MainActivity;
import com.example.movienigth.Model.ModelClient;
import com.example.movienigth.R;

import java.util.List;

public class ListClientFragment extends Fragment {

    ListView listView;
    List<ModelClient> lista;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ListClientFragment() {
        // Required empty public constructor
    }


    public static ListClientFragment newInstance(String param1, String param2) {
        ListClientFragment fragment = new ListClientFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_client,container,false);

        listView = (ListView)view.findViewById(R.id.idListViewClient);

        lista = MainActivity.adminDataBase.listClient();
        if(lista.size()>0){

            final AdapterClient adapterClient = new AdapterClient(getActivity(),lista);
            listView.setAdapter(adapterClient);

        }else{
            Toast.makeText(getContext(), "No existen clientes registrados", Toast.LENGTH_SHORT).show();
        }
        return inflater.inflate(R.layout.fragment_list_client, container, false);
    }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }




    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onResume() {
        super.onResume();

        getView().setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK){
                    Intent intent = new Intent(getContext(), MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getActivity(), "Menu Principal", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });
    }
}
