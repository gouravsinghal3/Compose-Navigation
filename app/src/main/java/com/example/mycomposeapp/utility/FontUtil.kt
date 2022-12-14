package com.example.mycomposeapp.utility

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.mycomposeapp.R

object FontUtil {

	val fontFamily = FontFamily(
		Font(R.font.raleway_black, FontWeight.Black),
		Font(R.font.raleway_bold, FontWeight.Bold),
		Font(R.font.raleway_thin, FontWeight.Thin)
	)
}