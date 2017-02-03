package edu.washington.amundm.quizdroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ResponseScreenFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ResponseScreenFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResponseScreenFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String COUNT = "count";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mCount;

    private OnFragmentInteractionListener mListener;

    public ResponseScreenFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ResponseScreenFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ResponseScreenFragment newInstance(String param1, String param2, String count) {
        ResponseScreenFragment fragment = new ResponseScreenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(COUNT, count);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mCount = getArguments().getString(COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_response_screen, container, false);
        TextView answer = (TextView)view.findViewById(R.id.answer);
        TextView correct = (TextView)view.findViewById(R.id.correct);
        TextView countText = (TextView)view.findViewById(R.id.count);

        answer.setText(mParam1);
        correct.setText(mParam2);
        countText.setText(mCount);
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

    public void changeR(Quiz current, Question currentQ){;

        TextView answer = (TextView)getView().findViewById(R.id.answer);
        TextView correct = (TextView)getView().findViewById(R.id.correct);
        TextView count = (TextView)getView().findViewById(R.id.count);

        String correctcount = "You have scored " + Overview.q.correct + " out of " +
                Overview.q.completed + " correct.";

        answer.setText(currentQ.response);
        correct.setText(currentQ.correct);
        count.setText(correctcount);
    }
}
