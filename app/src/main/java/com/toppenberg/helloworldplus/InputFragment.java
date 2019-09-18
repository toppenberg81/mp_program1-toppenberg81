package com.toppenberg.helloworldplus;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.text.Editable;
import android.util.Log;


public class InputFragment extends Fragment implements TextWatcher {

    private InputViewModel mViewModel;

        EditText et_name;
        Button Done;
        TextView NameDisplayed;
        String TAG = "InputFragment";


        public static InputFragment newInstance () {
        return new InputFragment();
    }

        @Override
        public View onCreateView (LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState){
        View rootView = inflater.inflate(R.layout.input_fragment, container, false);

        et_name = rootView.findViewById(R.id.ETname);
        et_name.addTextChangedListener(this);

        NameDisplayed = rootView.findViewById(R.id.textView3);

        return rootView;
    }

        @Override
        public void onActivityCreated (Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(InputViewModel.class);
        // TODO: Use the ViewModel
    }

        @Override
        public void beforeTextChanged (CharSequence s,int start, int count, int after){

    }

        @Override
        public void onTextChanged (CharSequence s,int start, int before, int count){
         Log.d(TAG, "TEXT CHANGED ");

        }

        @Override
        public void afterTextChanged (Editable s){
            //updates displayed name on fly
            NameDisplayed.setText("Hello " +s);
            Log.d(TAG, "Text changed to " + s);

    }
}
