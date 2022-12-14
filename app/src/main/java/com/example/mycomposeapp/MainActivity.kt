package com.example.mycomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

import kotlin.random.Random

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {

			val constraints = ConstraintSet {

				val greenBox = createRefFor("greenbox")
				val redBox = createRefFor("redbox")

				constrain(greenBox) {
					top.linkTo(parent.top)
					start.linkTo(parent.start)
					width = Dimension.value(100.dp)
					height = Dimension.value(100.dp)
				}

				constrain(redBox) {
					top.linkTo(parent.top)
					start.linkTo(greenBox.end)
					width = Dimension.value(100.dp)
					height = Dimension.value(100.dp)
				}
				createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Spread)
			}

			ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
				Box(modifier = Modifier
					.background(Color.Green)
					.layoutId("greenbox"))
				Box(modifier = Modifier
					.background(Color.Red)
					.layoutId("redbox"))
			}

			// list in compose
			//			LazyColumn {
			//
			//				itemsIndexed(listOf("gourav", "singhal", "Trident", "Embassy", "GNW","gourav", "singhal", "Trident", "Embassy", "GNW","gourav", "singhal", "Trident", "Embassy", "GNW","gourav", "singhal", "Trident", "Embassy", "GNW","gourav", "singhal", "Trident", "Embassy", "GNW"))
			//				{ _, item ->
			//					Text(text = item,
			//					     fontSize = 20.sp,
			//					     textAlign = TextAlign.Center,
			//					     modifier = Modifier
			//						     .fillMaxSize()
			//						     .padding(20.dp))
			//
			//				}
			//			}

			//  if want to material design in compose use scaffold it provide all xml material design in compose

			//			val scaffoldState = rememberScaffoldState()
			//			var valueState by remember {
			//				mutableStateOf("")
			//			}
			//			val scope = rememberCoroutineScope()
			//
			//			Scaffold(modifier = Modifier,
			//			         scaffoldState = scaffoldState) {
			//
			//				Column(modifier = Modifier.fillMaxSize(),
			//				       horizontalAlignment = Alignment.CenterHorizontally,
			//				       verticalArrangement = Arrangement.Center) {
			//
			//					TextField(value = valueState,
			//					          label = {
			//						          Text("Enter ur name")
			//					          },
			//					          onValueChange = {
			//						          valueState = it
			//					          })
			//
			//					Spacer(modifier = Modifier.height(15.dp))
			//
			//					Button(onClick = {
			//						scope.launch {
			//							scaffoldState.snackbarHostState.showSnackbar("Hello $valueState", "ok", SnackbarDuration.Short)
			//						}
			//					}) {
			//						Text(text = "Please greet me")
			//					}
			//				}
			//
			//			}
			//			Column() {
			//				var color = remember {
			//					mutableStateOf(Color.Green)
			//				}
			//				ButtonColor(Modifier
			//					            .weight(1f)
			//					            .fillMaxSize()) {
			//					color.value = it
			//				}
			//				Box(modifier = Modifier
			//					.weight(1f).fillMaxSize()
			//					.background(color.value))
			//			}


			//			val painter = painterResource(id = R.drawable.photo)
			//			val contentDescription = "this is compose image"
			//			val title = "this is compose image"
			//
			//			Box(
			//				modifier = Modifier
			//					.width(200.dp)
			//					.height(200.dp)
			//					.padding(15.dp),
			//			) {
			//				ImageCard(painter = painter, contentDescription = contentDescription, title = title)
			//			}

			//			Column(modifier = Modifier
			//				.background(Color.Green)
			//				.fillMaxSize()
			//				.border(10.dp, color = Color.Magenta)
			//				.padding(15.dp)) {
			//				Text(text = "Gourav", modifier = Modifier.offset(20.dp, 20.dp))
			//				Spacer(modifier = Modifier.padding(10.dp))
			//				Text(text = "singhal")
			//				Text(text = "swati")
			//			}
		}
	}

	@Composable
	fun ButtonColor(modifier : Modifier = Modifier, updateColor : (Color) -> Unit) {

		Box(modifier = modifier
			.fillMaxSize()
			.background(Color.Red)
			.clickable {
				updateColor(
					Color(
						Random.nextFloat(),
						Random.nextFloat(),
						Random.nextFloat(),
						1f
					)
				)
			})
	}

	//	@Composable
	//	fun ImageCard(
	//		painter : Painter,
	//		contentDescription : String,
	//		title : String,
	//		modifier : Modifier = Modifier
	//	) {
	//		Card(modifier = modifier.fillMaxWidth(),
	//		     shape = RoundedCornerShape(15.dp),
	//		     elevation = 5.dp
	//		) {
	//			Box(modifier = Modifier.fillMaxSize()) {
	//				Image(painter = painter, contentDescription = contentDescription, alignment = Alignment.Center,
	//				      contentScale = ContentScale.Crop)
	//
	//				Box(modifier = Modifier
	//					.fillMaxSize()
	//					.background(brush = Brush.verticalGradient(
	//						colors = listOf(
	//							Color.Transparent,
	//							Color.Black
	//						),
	//						startY = 300f
	//					)))
	//
	//				Box(
	//					modifier = Modifier
	//						.fillMaxSize()
	//						.padding(10.dp),
	//					contentAlignment = Alignment.BottomStart,
	//				) {
	//					Text(text = buildAnnotatedString {
	//						withStyle(
	//							style = SpanStyle(
	//								color = Color.Green,
	//								fontSize = 20.sp,
	//								fontFamily = FontUtil.fontFamily,
	//								fontWeight = FontWeight.Thin
	//							)
	//						) {
	//							append(title[0])
	//						}
	//						append(title.substring(1))
	//					}, style = TextStyle(color = Color.White, fontSize = 15.sp,
	//					fontFamily = FontUtil.fontFamily,
	//					fontWeight = FontWeight.Bold))
	//				}
	//			}
	//		}
	//
	//
	//	}

	//	@Composable
	//	fun Greeting(name : String) {
	//		Text(text = "Hello $name!")
	//	}
	//
	//	@Preview(showBackground = true)
	//	@Composable
	//	fun DefaultPreview() {
	//		MyComposeAppTheme {
	//			Greeting("Android")
	//		}
	//	}
}