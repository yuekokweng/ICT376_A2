package au.edu.murdoch.takemeaway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Date;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout coordinatorLayout;
    @TargetApi(Build.VERSION_CODES.O)

    private FloatingActionButton fab;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initials();
        clickListeners();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){


        String msg ="";
        switch (item.getItemId()){
            case R.id.delete:
                msg = "Delete";
                break;
            case R.id.search_bar:
                msg = "Search";
                break;
            case R.id.edit_query:
                msg = "Edit";
                break;
        }
        return super.onOptionsItemSelected(item);
    }



    private void initials() {
        coordinatorLayout=findViewById(R.id.mainLayout);
        fab = findViewById(R.id.fab);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


    private void clickListeners() {
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onClick(View v) {
                CreateNoteFragment fragment =  CreateNoteFragment.newInstance();
                //Toast.makeText(getApplicationContext(),"TEST"+fragment,Toast.LENGTH_LONG).show();
                getSupportFragmentManager().beginTransaction().addToBackStack(null);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

                CoordinatorLayout.LayoutParams p = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
                p.setAnchorId(View.NO_ID);
                fab.setLayoutParams(p);
                fab.setVisibility(View.GONE);
            }
        });
    }

}
