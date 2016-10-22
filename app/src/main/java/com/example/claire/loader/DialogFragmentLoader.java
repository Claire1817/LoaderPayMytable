package com.example.claire.loader;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.DialogFragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Claire on 20/10/2016.
 */

public class DialogFragmentLoader extends DialogFragment {

    static DialogFragmentLoader newInstance() {
        return new DialogFragmentLoader();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.dialog_fragment_loader, container, false);

        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        getChildFragmentManager().beginTransaction()
                            .add(R.id.container, LoaderFragment.newInstance(Color.parseColor("#FFFFFF")))
                                .commit();
        return rootView;
    }

    @Override
    public void onStart() {

        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
        }
    }

}
