package com.example.activtyone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityScreen extends AppCompatActivity {

    private ImageView ivHome, ivWallet, ivChart, ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.actvity_activityscreen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activityRoot), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        
        ivHome = findViewById(R.id.ivHome);
        ivWallet = findViewById(R.id.ivWallet);
        ivChart = findViewById(R.id.ivChart);
        ivProfile = findViewById(R.id.ivProfile);
        
        setupNavigationIcons();
        setIconActive(ivChart);
        setIconInactive(ivHome);
    }

    private void setupNavigationIcons() {
        ivHome.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        ivWallet.setOnClickListener(v -> {
        });

        ivChart.setOnClickListener(v -> {
        });

        ivProfile.setOnClickListener(v -> {
        });
    }

    private void setIconActive(ImageView icon) {
        if (icon != null) {
            if (icon == ivHome) {
                icon.setImageResource(R.drawable.ic_home_selected);
                icon.clearColorFilter();
            } else {
                icon.setColorFilter(ContextCompat.getColor(this, R.color.nav_active));
            }
        }
    }

    private void setIconInactive(ImageView icon) {
        if (icon != null) {
            if (icon == ivHome) {
                icon.setImageResource(R.drawable.ic_home);
                icon.setColorFilter(ContextCompat.getColor(this, R.color.nav_inactive));
            } else {
                icon.setColorFilter(ContextCompat.getColor(this, R.color.nav_inactive));
            }
        }
    }
}
