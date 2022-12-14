package com.example.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mycomposeapp.nav.Navigation

class NavActivity : ComponentActivity() {

	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			Navigation()
		}
	}
}
