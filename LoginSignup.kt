package com.jetpack.bustracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jetpack.bustracker.ui.theme.BusTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusTrackerTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation(){
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login"){
        composable(route = "Login"){ Login(navController) }
        composable(route = "Signup"){ Signup(navController) }
        composable(route = "ProfileID"){ProfileID(navController)}
    }
}

@Composable
fun Login(navController: NavController){

    var text by remember {
        mutableStateOf("")
    }
    var pwd by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Login", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = text,
            onValueChange = { text = it },
            label = {
                Text(text = "Mobile Number")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = pwd,
            onValueChange = { pwd = it },
            label = {
                Text(text = "Password")
            }
        )
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp, 10.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "Forgot Password?")
        }
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = { navController.navigate(route = "") }) {
            Text(text = "Login", fontSize = 20.sp, color = Color.Black)
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(text = "Don't have an account?")

            TextButton(onClick = { navController.navigate(route = "Signup") }) {
                Text(text = "Sign Up", color = Color.Gray, fontSize = 15.sp,fontWeight = FontWeight.Bold)
            }
        }
    }
}
@Composable
fun Signup(navController: NavController){
    var text by remember {
        mutableStateOf("")
    }
    var pwd by remember {
        mutableStateOf("")
    }
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "SignUp", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = text,
            onValueChange = { text = it },
            label = {
                Text(text = "Mobile Number")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(value = pwd,
            onValueChange = { pwd = it },
            label = {
                Text(text = "Password")
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedButton(onClick = { navController.navigate(route = "Login") }) {
            Text(text = "Signup", fontSize = 20.sp, color = Color.Black)
        }
    }
}

@Composable
fun ProfileID(navController: NavController){
    var name by remember {
        mutableStateOf("")
    }
    TextField(value = name,
        onValueChange = {name = it},
        label = {
            Text(text = "Name")
        }
    )
}
