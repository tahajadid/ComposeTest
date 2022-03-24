package com.example.composetest.components

import android.content.res.Configuration
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetest.R
import com.example.composetest.ui.theme.GoldColor
import com.example.composetest.ui.theme.PrimaryColor
import com.example.composetest.ui.theme.WhiteBackground

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun LoginPage() {

    val emailValue = remember {
        mutableStateOf("")
    }

    val passwordValue = remember {
        mutableStateOf("")
    }

    val passwordVisibility = remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFE1FFE2))
                .padding(100.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(R.drawable.login_capture),
                contentDescription = "Content description for visually impaired"
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .fillMaxHeight(0.5F)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(WhiteBackground)
                .padding(10.dp)
        ) {
            Text(
                text = "Sign In",
                color = Color.White,
                fontSize = 24.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.padding(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    label = { Text(text = "Email Address", color = Color.White) },
                    placeholder = { Text(text = "Email Address", color = Color.White) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                painter = painterResource(R.drawable.ic_baseline_remove_red_eye_24),
                                contentDescription = null,
                                Modifier.fillMaxWidth(),
                                tint = if (passwordVisibility.value) PrimaryColor else Color.Gray
                            )
                        }
                    },
                    label = { Text("Password", color = Color.White) },
                    placeholder = { Text(text = "Password", color = Color.White) },
                    singleLine = true,
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None else
                        PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = GoldColor,
                        contentColor = Color(0xFFFFF5EE),
                        disabledBackgroundColor = Color(0xFFD1BAD5),
                        disabledContentColor = Color(0xFF000000)
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp)
                ) {
                    Text(text = "Sign In")
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Text(
                    text = "Create An Account",
                    color = Color.White,
                    modifier = Modifier.clickable(onClick = {
                    }),
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}
