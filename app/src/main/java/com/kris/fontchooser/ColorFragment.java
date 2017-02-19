package com.kris.fontchooser;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
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
public class ColorFragment extends Fragment {

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

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_color, container, false);

        ButterKnife.bind(this, v);

        return v;

    }

    @OnClick(R.id.textColorButton)
    public void setTextColor(){

        EditText alphaText = (EditText) getView().findViewById(R.id.alphaNum);
        EditText redText = (EditText) getView().findViewById(R.id.redNum);
        EditText greenText = (EditText) getView().findViewById(R.id.greenNum);
        EditText blueText = (EditText) getView().findViewById(R.id.blueNum);

        int alpha = 0;
        int red = 0;
        int green = 0;
        int blue = 0;

        //convert strings to int
        try{

            alpha = Integer.parseInt(alphaText.getText().toString());
            red = Integer.parseInt(redText.getText().toString());
            green = Integer.parseInt(greenText.getText().toString());
            blue = Integer.parseInt(blueText.getText().toString());

            //check if valid nums. If so, make callback
            if(alpha > 255 || red > 255 || green > 255 || blue > 255){
                Toast.makeText(getActivity(), "Error: a number is outside of expected 0 to 255 range", Toast.LENGTH_SHORT).show();
            }else{
                callback.changeTextColor(alpha, red, green, blue);
            }

        }catch(Exception e){
            Log.e("Error: ", "Invalid Number");
            Toast.makeText(getActivity(), "Error: Invalid Number", Toast.LENGTH_SHORT).show();
        }

    }

}
