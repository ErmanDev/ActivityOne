package com.example.activtyone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private ImageView ivHome, ivWallet, ivChart, ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        setupNavigationIcons();
    }

    private void setupNavigationIcons() {
        ivHome = findViewById(R.id.ivHome);
        ivWallet = findViewById(R.id.ivWallet);
        ivChart = findViewById(R.id.ivChart);
        ivProfile = findViewById(R.id.ivProfile);

        ivHome.setOnClickListener(v -> {
            // Already on home, no action
        });

        ivWallet.setOnClickListener(v -> {
            // Add navigation logic if needed
        });

        ivChart.setOnClickListener(v -> {
            // Navigate to ActivityScreen
            Intent intent = new Intent(this, ActivityScreen.class);
            startActivity(intent);
        });

        ivProfile.setOnClickListener(v -> {
            // Add navigation logic if needed
        });
    }

    private void setIconActive(ImageView icon) {
        icon.setColorFilter(ContextCompat.getColor(this, R.color.nav_active));
    }

    private void setIconInactive(ImageView icon) {
        icon.setColorFilter(ContextCompat.getColor(this, R.color.nav_inactive));
    }
}