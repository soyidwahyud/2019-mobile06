package id.ac.polinema.idealbodyweight.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import id.ac.polinema.idealbodyweight.R;
import id.ac.polinema.idealbodyweight.util.BMIcalc;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BMIFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class BMIFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public BMIFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bmi,container,false);
        final EditText mass = view.findViewById(R.id.massText);
        final EditText height = view.findViewById(R.id.heightText);

        Button calc = view.findViewById(R.id.button_calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    String massString = mass.getText().toString();
                    String heightString = height.getText().toString();
                    if ((!TextUtils.isEmpty(massString)) && !TextUtils.isEmpty(heightString)) {
                        float mass = Float.parseFloat(massString);
                        float height = Float.parseFloat(heightString);
                        BMIcalc bmi = new BMIcalc(mass, height/100);
                        mListener.onCalculateBMIIndexClicked((bmi.keterangan()));
                    } else {
                        Toast.makeText(getActivity(), "Please input", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onCalculateBMIIndexClicked(String keterangan);
    }
}
