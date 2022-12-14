package com.example.mycomposeapp.nav

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
	val navController = rememberNavController()

	val navHost = NavHost(navController = navController, startDestination = Screen.MainScreen.route) {

		composable(Screen.MainScreen.route) {
			MainScreen(navController = navController)
		}

		composable(Screen.DetailScreen.route + "/{name}",

		           arguments = listOf(
			           navArgument("name") {
				           type = NavType.StringType
				           defaultValue = "gourav"
				           nullable = true
			           }
		           )) {

			DetailScreen(name = it.arguments?.getString("name"))
		}
	}
}


@Composable
fun MainScreen(navController : NavController) {
	var text by remember {
		mutableStateOf("")
	}

	Column(modifier = Modifier
		.fillMaxSize()
		.padding(20.dp),
	       verticalArrangement = Arrangement.Center) {

		TextField(value = text, modifier = Modifier.fillMaxWidth(),
		          onValueChange = { it ->
			          text = it
		          })

		Spacer(modifier = Modifier.padding(10.dp))

		Button(onClick = {
			navController.navigate(Screen.DetailScreen.withArgs(text))
		},
		       modifier = Modifier.align(Alignment.End)) {

			Text(text = "go to detail screen")
		}
	}

}

@Composable
fun DetailScreen(name : String?) {

	Box(modifier = Modifier
		.fillMaxSize()
		.padding(30.dp)) {

		Text(text = "Hello $name")
	}
}