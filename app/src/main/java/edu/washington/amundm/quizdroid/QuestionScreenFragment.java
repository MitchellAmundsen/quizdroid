package edu.washington.amundm.quizdroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;
import android.util.Log;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";
    private static final String ARG_PARAM4 = "param4";
    private static final String ARG_ANSWER = "aparam";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;
    private String mParam4;
    private String atext;
    private String retAnswer = "";

    private OnFragmentInteractionListener mListener;

    public QuestionScreenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuestionScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static QuestionScreenFragment newInstance(String r1, String r2,
                                                     String r3, String r4, String atext) {
        QuestionScreenFragment fragment = new QuestionScreenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, r1);
        args.putString(ARG_PARAM2, r2);
        args.putString(ARG_PARAM3, r3);
        args.putString(ARG_PARAM4, r4);
        args.putString(ARG_ANSWER, atext);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
            mParam4 = getArguments().getString(ARG_PARAM4);
            atext = getArguments().getString(ARG_ANSWER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question_screen, container, false);

        TextView qtext = (TextView)view.findViewById(R.id.question);
        RadioButton r1 = (RadioButton)view.findViewById(R.id.r1);
        RadioButton r2 = (RadioButton)view.findViewById(R.id.r2);
        RadioButton r3 = (RadioButton)view.findViewById(R.id.r3);
        RadioButton r4 = (RadioButton)view.findViewById(R.id.r4);

        qtext.setText(atext);
        r1.setText(mParam1);
        r2.setText(mParam2);
        r3.setText(mParam3);
        r4.setText(mParam4);

        RadioGroup r = (RadioGroup)view.findViewById(R.id.rg);
        r.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(RadioGroup group, int id){
                //getActivity().findViewById(R.id.next).setEnabled(true);
                RadioButton answer = (RadioButton) group.findViewById(id);
                retAnswer = (String)answer.getText();
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        /*
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        */
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
        void onFragmentInteraction(Uri uri);
    }

    public String getAnswer(){
        return retAnswer;
    }
}
