package com.kris.fontchooser;


import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class TypefaceFragment extends Fragment {

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

    public TypefaceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_typeface, container, false);

        ButterKnife.bind(this, v);

        return v;

    }

    @OnClick({R.id.defaultButton, R.id.defaultBoldButton, R.id.monoSpaceButton, R.id.sansSerifButton, R.id.serifButton})
    public void setTypeface(View v){

        Button button = (Button) v;

        String typeface = button.getText().toString();

        callback.changeTypeface(typeface);

    }

}
