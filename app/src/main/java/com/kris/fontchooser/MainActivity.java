package com.kris.fontchooser;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Optional;

public class MainActivity extends Activity implements CommunicationInterface {

    //Initialize fields for intent
    private int mIntentCode = 0;
    private int mAlpha = 255;
    private int mRed = 0;
    private int mGreen = 0;
    private int mBlue = 0;
    private float mTextSize = 20;
    private String mTextStyle = "Normal";
    private String mTextTypeface = "Default";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();


        if(intent != null && intent.hasExtra("intentCode")){
            //Activity called with an intent
            Log.d("Intent? ", "YUP!");
            mIntentCode = intent.getIntExtra("mIntentCode", 0);
            Log.d("Message", "" + mIntentCode);
            setContentView(R.layout.activity_main_intent);
        }else{
            //Activity not called with an intent
            setContentView(R.layout.activity_main);
        }

        ButterKnife.bind(this);
    }

    @Optional
    @OnClick(R.id.intentButton)
    public void returnIntent(){

        Intent result = new Intent();

        result.putExtra("alpha", mAlpha);
        result.putExtra("red", mRed);
        result.putExtra("green", mGreen);
        result.putExtra("blue", mBlue);
        result.putExtra("textSize", mTextSize);
        result.putExtra("textStyle", mTextStyle);
        result.putExtra("textTypeface", mTextTypeface);

        setResult(mIntentCode, result);
        finish();

    }

    @Optional
    @OnClick(R.id.fabStyle)
    public void chooseStyle(){

        StyleFragment styleFragment = new StyleFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fragmentFrame, styleFragment);
        ft.commit();

        System.out.println("chooseStyle");

    }

    @Optional
    @OnClick(R.id.fabColor)
    public void chooseColor(){

        ColorFragment colorFragment = new ColorFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fragmentFrame, colorFragment);
        ft.commit();

        System.out.println("chooseColor");

    }

    @Optional
    @OnClick(R.id.fabSize)
    public void chooseSize(){

        SizeFragment sizeFragment = new SizeFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fragmentFrame, sizeFragment);
        ft.commit();

        System.out.println("chooseSize");

    }

    @Optional
    @OnClick(R.id.fabTypeface)
    public void chooseTypeface(){

        TypefaceFragment typefaceFragment = new TypefaceFragment();

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.fragmentFrame, typefaceFragment);
        ft.commit();

        System.out.println("chooseTypeface");

    }

    @Override
    public void onSuccess() {

        Log.d("Note: ", "SUCCESS");

    }

    @Override
    public void changeTextSize(Float sizeNum){

        EditText editText = (EditText)findViewById(R.id.finalFont);

        if(sizeNum != null && editText != null){
            if(sizeNum > 100){
                sizeNum = (float)99;
            }
            mTextSize = sizeNum;
            editText.setTextSize(sizeNum);
        }

    }

    @Override
    public void changeTextColor(int a, int r, int g, int b){

        EditText editText = (EditText)findViewById(R.id.finalFont);

        editText.setTextColor(Color.argb(a, r, g, b));

        mAlpha = a;
        mRed = r;
        mGreen = g;
        mBlue = b;

    }

    @Override
    public void changeStyle(String s){

        EditText editText = (EditText)findViewById(R.id.finalFont);

        switch (s){

            case "Normal":
                mTextStyle = s;
                editText.setTypeface(editText.getTypeface(), Typeface.NORMAL);
                break;

            case "Bold":
                mTextStyle = s;
                editText.setTypeface(editText.getTypeface(), Typeface.BOLD);
                break;

            case "Italic":
                mTextStyle = s;
                editText.setTypeface(editText.getTypeface(), Typeface.ITALIC);
                break;

            case "Bold Italic":
                mTextStyle = s;
                editText.setTypeface(editText.getTypeface(), Typeface.BOLD_ITALIC);
                break;

        }

    }

    @Override
    public void changeTypeface(String s){

        EditText editText = (EditText)findViewById(R.id.finalFont);

        switch (s){

            case "Default":
                mTextTypeface = s;
                editText.setTypeface(Typeface.DEFAULT, editText.getTypeface().getStyle());
                break;

            case "Default Bold":
                mTextTypeface = s;
                editText.setTypeface(Typeface.DEFAULT_BOLD, editText.getTypeface().getStyle());
                break;

            case "Monospace":
                mTextTypeface = s;
                editText.setTypeface(Typeface.MONOSPACE, editText.getTypeface().getStyle());
                break;

            case "Sans Serif":
                mTextTypeface = s;
                editText.setTypeface(Typeface.SANS_SERIF, editText.getTypeface().getStyle());
                break;

            case "Serif":
                mTextTypeface = s;
                editText.setTypeface(Typeface.SERIF, editText.getTypeface().getStyle());
                break;

        }

    }

}
