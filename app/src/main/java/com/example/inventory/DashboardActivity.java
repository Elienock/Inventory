package com.example.inventory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        GridLayout grid = findViewById(R.id.grid);
        CardView card_1 = findViewById(R.id.card_1);
        CardView card_2 = findViewById(R.id.card_2);
        CardView card_3 = findViewById(R.id.card_3);
        CardView card_4 = findViewById(R.id.card_4);
        CardView card_5 = findViewById(R.id.card_5);
        ImageView menu_bar = findViewById(R.id.dashboard_menu);
        ImageView expense = findViewById(R.id.expense);
        ImageView report = findViewById(R.id.report);
        ImageView expunge= findViewById(R.id.expunge);
        ImageView search = findViewById(R.id.search);
        TextView entry_text = findViewById(R.id.entry_text);
        TextView  expense_text = findViewById(R.id.expense_text);
        TextView  report_text = findViewById(R.id.report_text);
        TextView  search_text = findViewById(R.id.search_text);
        TextView  expunge_text = findViewById(R.id.expunge_text);

        menu_bar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showMenu(view);
            }
        });

        //Hide ActionBar from any particular activity using Java code
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
    private void showMenu(View view){
        PopupMenu popupMenu = new PopupMenu(DashboardActivity.this,view);
        popupMenu.getMenuInflater().inflate(R.menu.menu_1,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.logout_item) {
                    Intent intent = new Intent(DashboardActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else if(menuItem.getItemId() == R.id.register_item) {
                    Intent intent = new Intent(DashboardActivity.this, RegisterActivity.class);
                    startActivity(intent);
                }
                else{
                    Intent intent = new Intent(DashboardActivity.this, AboutActivity.class);
                    startActivity(intent);
                }


                return false;
            }
        });

    }
}