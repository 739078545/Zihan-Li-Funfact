// MainActivity.kt

package com.example.funfact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quoteofthedayapp.ui.theme.MotivationalQuotesTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Set the Compose content
        setContent {
            MotivationalQuotesTheme {
                // A surface container using the 'background' color from the theme
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(0xFFE3F2FD)), // Light blue background
                    contentAlignment = Alignment.Center
                ) {
                    FactDisplay()
                }
            }
        }
    }
}

@Composable
fun FactDisplay() {
    // List of FunFact
    val quotes = listOf(
        "Honey never spoils; archaeologists have found edible honey in ancient Egyptian tombs.",
        "A single strand of human hair can support up to 100 grams in weight.",
        "Octopuses have three hearts and blue blood.",
        "Bananas are berries, but strawberries aren't.",
        "The Eiffel Tower can be 15 cm taller during the summer due to thermal expansion.",
        "Wombat poop is cube-shaped.",
        "Humans share 50% of their DNA with bananas.",
        "There are more stars in the universe than grains of sand on Earth.",
        "A day on Venus is longer than its year.",
        "Sloths can hold their breath for up to 40 minutes underwater.",
        "The inventor of the Frisbee was turned into a Frisbee after he died.",
        "Sea otters hold hands while sleeping to avoid drifting apart.",
        "There are more possible iterations of a game of chess than atoms in the known universe.",
        "A group of flamingos is called a 'flamboyance.'",
        "Cows have best friends and become stressed when separated.",
        "The heart of a blue whale is as large as a small car.",
        "Hot water freezes faster than cold water, a phenomenon known as the Mpemba effect.",
        "Some turtles can breathe through their butts.",
        "The shortest war in history lasted 38 minutes between Britain and Zanzibar in 1896.",
        "Rainbows can only be seen in the morning or late afternoon.",
        "Pigeons can recognize themselves in a mirror.",
        "A teaspoon of honey represents the life work of 12 bees.",
        "Butterflies taste with their feet.",
        "A cloud can weigh over a million pounds.",
        "The first computer virus was created in 1983.",
        "Pineapples take two years to grow.",
        "There are more trees on Earth than stars in the Milky Way galaxy.",
        "A day on Mercury lasts longer than its year.",
        "Peanuts are not nuts; they are legumes.",
        "Humans and giraffes have the same number of neck bones.",
        "The world's oldest piece of chewing gum is over 9,000 years old.",
        "Koalas have fingerprints almost identical to humans.",
        "The inventor of the microwave appliance only received $2 for his discovery.",
        "A bolt of lightning contains enough energy to toast 100,000 slices of bread.",
        "Some cats are allergic to humans.",
        "Bamboo can grow up to 35 inches in a single day.",
        "There are more bacteria in your mouth than there are people on Earth.",
        "The unicorn is the national animal of Scotland.",
        "Your taste buds have a lifespan of about 10 days.",
        "The longest English word without a vowel is 'rhythms.'",
        "A sneeze travels about 100 miles per hour.",
        "Polar bears are nearly invisible under infrared photography.",
        "The inventor of the Pringles can is buried in one.",
        "A single cloud can produce up to 1.5 million lightning bolts.",
        "Snails can sleep for three years.",
        "The first alarm clock could only ring at one time: 4 a.m.",
        "The total weight of all ants on Earth is greater than the weight of all humans.",
        "Humans can distinguish over a trillion different smells.",
        "The fingerprints of a koala are so similar to humans that they can be mistaken at a crime scene.",
        "There is a species of jellyfish that is biologically immortal."
    )

    // Remember the current quote index
    var currentFact by remember { mutableStateOf(getRandomIndex(quotes.size)) }

    // Column to arrange Text and Button vertically
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
    ) {
        // Display the FunFact
        Text(
            text = quotes[currentFact],
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Blue,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
        )

        // Button to change the FunFact
        Button(

            onClick = {
                var newIndex = getRandomIndex(quotes.size)
                // Ensure a different FunFact is selected
                while (newIndex == currentFact && quotes.size > 1) {
                    newIndex = getRandomIndex(quotes.size)
                }
                currentFact = newIndex
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            modifier = Modifier
                .height(50.dp)
                .width(200.dp)
        ) {
            Text(
                text = "New FunFact",
                fontSize = 20.sp,
                color = Color.White
            )
        }
    }
}

// Helper function to get a random index
fun getRandomIndex(size: Int): Int {
    return Random.nextInt(size)
}

