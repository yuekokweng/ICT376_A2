package au.edu.murdoch.takemeaway;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class CreateNoteFragment extends Fragment {

    private View rootView;
    private TextView dateTextView;

    public static CreateNoteFragment newInstance(){
        Bundle args = new Bundle();
        CreateNoteFragment fragment = new CreateNoteFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @SuppressLint("ValidFragment")
    private CreateNoteFragment(){

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_create_note, container, false);
        dateTextView = rootView.findViewById(R.id.dateEditText);
        String currentDateTimeString = java.text.DateFormat.getDateInstance().format(new Date());
        dateTextView.setText(currentDateTimeString);

        initials(rootView);
        onClickListeners();
        return rootView;
    }



    private void initials(View rootView){

    }

    private void onClickListeners(){

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){

    }

    public interface LayoutFactory {
        View produceLayout(LayoutInflater inflater, @Nullable ViewGroup container);
    }
    public final class IdLayoutFactory implements LayoutFactory {
        private final int layoutId;
        public IdLayoutFactory(int layoutId) {
            this.layoutId = layoutId;
        }
        @Override
        public View produceLayout(LayoutInflater inflater, @Nullable ViewGroup container) {
            return inflater.inflate(layoutId, container, false);
        }
    }
    public final class DummyLayoutFactory implements LayoutFactory {
        private final View view;
        public DummyLayoutFactory(View view) {
            this.view = view;
        }
        @Override
        public View produceLayout(LayoutInflater inflater, @Nullable ViewGroup container) {
            return view;
        }
    }

}
