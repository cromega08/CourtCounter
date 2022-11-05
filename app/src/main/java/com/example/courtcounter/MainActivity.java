package com.example.courtcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/*
    <Court Counter: A point counter for basketball games>
    Copyright (C) <2022>  <Cromega>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <https://www.gnu.org/licenses/>.

* */
public class MainActivity extends AppCompatActivity {

    TextView teamA, pointsA, teamB, pointsB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        teamA = findViewById(R.id.team_a_name);
        pointsA = findViewById(R.id.a_points);
        teamB = findViewById(R.id.team_b_name);
        pointsB = findViewById(R.id.b_points);
    }

    @SuppressLint("DefaultLocale")
    public void increase(View view) {
        String team = getResources().getResourceEntryName(view.getId());
        TextView selected = team.contains("a")? pointsA:pointsB;
        int newValue = Integer.parseInt(selected.getText().toString()) + Integer.parseInt(String.valueOf(team.charAt(team.length() - 1)));
        selected.setText(String.format("%d", newValue));
    }

    public void reset(View view) {
        teamA.setText(R.string.team_a);
        teamB.setText(R.string.team_b);
        pointsA.setText(R.string.points);
        pointsB.setText(R.string.points);
    }
}