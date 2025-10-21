package com.example.cleanarchitecturenotesapp.feauturenote.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cleanarchitecturenotesapp.feauturenote.presentation.addeditnote.AddEditScreen
import com.example.cleanarchitecturenotesapp.feauturenote.presentation.notes.NotesScreen
import com.example.cleanarchitecturenotesapp.feauturenote.presentation.notes.NotesViewModel
import com.example.cleanarchitecturenotesapp.feauturenote.presentation.util.Screen
import com.example.cleanarchitecturenotesapp.ui.theme.CleanArchitectureNotesAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: NotesViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App(viewModel)
            /*  CleanArchitectureNotesAppTheme {
                Surface(color = MaterialTheme.colorScheme.background){
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.NotesScreen.route){
                        composable(route = Screen.NotesScreen.route) {
                            NotesScreen(navController= navController,viewModel)
                        }
                        composable(route = Screen.AddEditNoteScreen.route+ "?noteId={noteId}&noteColor={noteColor}",
                            arguments = listOf(
                                navArgument(name = "noteId"){
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "noteColor"){
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ) {
                           val color  = it.arguments?.getInt("noteColor")?:-1
                            AddEditScreen(navController, color)
                        }
                    }
                }
            }*/
        }
    }
}

@Composable
fun App(viewModel: NotesViewModel) {
    CleanArchitectureNotesAppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            val navController = rememberNavController()

            // Navigation Host
            NavHost(navController = navController, startDestination = Screen.NotesScreen.route) {

                composable(route = Screen.NotesScreen.route) {
                    NotesScreen(navController = navController, viewModel)
                }

                composable(
                    route = Screen.AddEditNoteScreen.route + "?noteId={noteId}&noteColor={noteColor}",
                    arguments = listOf(
                        navArgument(name = "noteId") {
                            type = NavType.IntType
                            defaultValue = -1
                        },
                        navArgument(name = "noteColor") {
                            type = NavType.IntType
                            defaultValue = -1
                        }
                    )
                ) {
                    val noteId = it.arguments?.getInt("noteId") ?: -1
                    val noteColor = it.arguments?.getInt("noteColor") ?: -1
                    AddEditScreen(navController, noteColor)
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CleanArchitectureNotesAppTheme {
        Greeting("Android")
    }
}