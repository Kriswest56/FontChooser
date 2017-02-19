package com.kris.fontchooser;

/**
 * Created by Kris on 2/18/2017.
 */

public interface CommunicationInterface {

    void changeTextSize(Float textSize);

    void changeTextColor(int a, int r, int g, int b);

    void changeStyle(String s);

    void changeTypeface(String s);

    void onSuccess();

}
