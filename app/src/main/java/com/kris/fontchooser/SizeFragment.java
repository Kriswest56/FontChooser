package com.kris.fontchooser;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class SizeFragment extends Fragment {

    CommunicationInterface callback;

    @Override
    public void onActivityCreated(Bundle outState) {
        super.onActivityCreated(outState);

        callback= (CommunicationInterface) getActivity();

        callback.onSuccess();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        callback= (CommunicationInterface) context;

    }

    public SizeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_size, container, false);

        ButterKnife.bind(this, v);

        return v;
    }

    @OnClick(R.id.textSizeButton)
    public void setTextSize(){

        if(getView() != null){
            EditText editText = (EditText) getView().findViewById(R.id.textSizeNum);

            try{
                Float num = Float.parseFloat(editText.getText().toString());
                callback.changeTextSize(num);
            }catch (Exception e){
                Log.e("Error: ", "Invalid Number");
                Toast.makeText(getActivity(), "Error: Invalid Number", Toast.LENGTH_SHORT).show();
            }
        }

    }

}
