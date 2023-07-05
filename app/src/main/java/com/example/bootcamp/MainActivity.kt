package com.example.bootcamp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setStatusBarColor(
                    color = Color.Transparent,
                    darkIcons = false
                )
            }
            ProjectCard()
        }
    }
}

@Composable
fun ProjectCard() {
    LazyColumn(content = {
        item {
            Box {
                ImageHeader()
                Logo()
                Marks()
            }
        }
        item { Description() }
        item { Spacer(modifier = Modifier.height(20.dp)) }
        item { PreviewDotA() }
        item {
            Text(
                "Reviews & Ratings", modifier = Modifier
                    .size(200.dp, 30.dp)
                    .padding(start = 24.dp, top = 6.dp), color = Color(0xFFEEF2FB),
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.sk_modernist_bold))
            )
        }
        item { ReviewRatingsicon() }
        item { Spacer(modifier = Modifier.height(20.dp))}
        item { Com() }
        item { Spacer(modifier = Modifier.height(20.dp))}
        item { InstallButton() }
        item { Spacer(modifier = Modifier.height(20.dp))}
    }, modifier = Modifier
        .height(1240.dp)
        .fillMaxWidth()
        .background(color = Color(0xFF050B18)))
}

@Composable
fun ImageHeader() {
    Image(
        painter = painterResource(id = R.drawable.main_label),
        contentDescription = "main_label",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(628.dp, 354.dp)
    )
}

@Composable
fun Logo() {
    Row(
        modifier = Modifier
            .height(420.dp)
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start
    ) {
        Box(modifier = Modifier.size(130.dp)){
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
        }
        Column(modifier = Modifier.padding(bottom = 40.dp)) {
            Text(
                "DoTA 2",
                color = Color.White,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier
                        .size(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier
                        .size(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier
                        .size(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier
                        .size(10.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "star",
                    modifier = Modifier
                        .size(10.dp)
                )
                Text("70M",
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(start = 5.dp),
                    color = Color(0xFF45454D),
                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)))
            }

        }
    }
}

@Composable
fun Marks() {
    val contextForToast = LocalContext.current.applicationContext
    Row(
        modifier = Modifier
            .height(400.dp)
            .padding(start = 24.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Start

    ) {
        Button(onClick = {
            Toast.makeText(contextForToast, "Moving to MOBA category", Toast.LENGTH_SHORT).show()
        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF44A9F4).copy(alpha = 0.24f)), modifier = Modifier
            .size(53.dp, 18.dp),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(20.dp))
        {
            Text("MOBA", fontSize = 7.sp,
                color = Color(0xFF41A0E7),
                fontFamily = FontFamily(Font(R.font.montserrat_medium))
            )
        }
        Button(
            onClick = {
                Toast.makeText(contextForToast, "Moving to Multiplayer category", Toast.LENGTH_SHORT).show()
            }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF44A9F4).copy(alpha = 0.24f)),
            modifier = Modifier
                .size(93.dp, 18.dp)
                .padding(start = 5.dp),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(20.dp)
        )
        {
            Text("MULTIPLAYER", fontSize = 7.sp,
                color = Color(0xFF41A0E7),
                fontFamily = FontFamily(Font(R.font.montserrat_medium)))
        }
        Button(onClick = {
            Toast.makeText(contextForToast, "Moving to Strategy category", Toast.LENGTH_SHORT).show()

        }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF44A9F4).copy(alpha = 0.24f)), modifier = Modifier
            .size(73.dp, 18.dp)
            .padding(start = 5.dp),
            contentPadding = PaddingValues(0.dp),
            shape = RoundedCornerShape(20.dp))
        {
            Text("STRATEGY", fontSize = 7.sp,
                color = Color(0xFF41A0E7),
                fontFamily = FontFamily(Font(R.font.montserrat_medium)))
        }
    }
}


@Composable
fun Description() {
    Text(
        "DotA 2 is a multiplayer online battle arena (MOBA) game which has two teams of five players compete to collectively destroy a large structure defended by the opposing team known as the \"Ancient\", whilst defending their own.",
        fontSize = 12.sp,
        color = Color(0xFFEEF2FB),
        fontFamily = FontFamily(Font(R.font.sk_modernist_regular)),
        modifier = Modifier
            .height(70.dp)
            .fillMaxWidth()
            .padding(start = 24.dp, end = 24.dp)
    )
}

@Composable
fun PreviewDotA() {
    val contextForToast = LocalContext.current.applicationContext
    LazyRow(
        content = {
            item {
                Box(modifier = Modifier
                    .padding(start = 10.dp, end = 5.dp)
                    .size(240.dp, 120.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.example1),
                        contentDescription = "example1",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(125.dp)
                            .width(275.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                Toast
                                    .makeText(
                                        contextForToast,
                                        "Video #1",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "play",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
            }
            item {
                Box(modifier = Modifier
                    .padding(start = 5.dp, end = 10.dp)
                    .size(240.dp, 120.dp)){
                    Image(
                        painter = painterResource(id = R.drawable.example2),
                        contentDescription = "example2",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(125.dp)
                            .width(275.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .clickable {
                                Toast
                                    .makeText(
                                        contextForToast,
                                        "Video #2",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }

                    )
                    Image(
                        painter = painterResource(id = R.drawable.play),
                        contentDescription = "play",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }, modifier = Modifier
            .height(140.dp)
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
    )
}


@Composable
fun ReviewRatingsicon() {
    Box(
        modifier = Modifier.height(58.dp).fillMaxWidth().padding(top = 5.dp)
    ) {
        Row {
            Text("4.9",
                fontSize = 48.sp,
                color = Color.White,
                modifier = Modifier
                    .padding(start = 24.dp, end = 24.dp),
                fontFamily = FontFamily(Font(R.font.sk_modernist_bold))
            )

            Box(
                modifier = Modifier
                    .size(80.dp, 60.dp)
                    .padding(top = 15.dp)
            ){
                Column {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "star",
                            modifier = Modifier
                                .size(14.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "star",
                            modifier = Modifier
                                .size(14.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "star",
                            modifier = Modifier
                                .size(14.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "star",
                            modifier = Modifier
                                .size(14.dp)
                        )
                        Image(
                            painter = painterResource(id = R.drawable.star),
                            contentDescription = "star",
                            modifier = Modifier
                                .size(9.dp)
                        )}
                    Spacer(modifier = Modifier.height(3.dp))
                    Text("70M Reviews", fontSize = 12.sp, color = Color(0xFFA8ADB7))
                }
            }
        }
    }
}


@Composable
fun Com() {
    Column {
        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse8),
                contentDescription = "ellipse8",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Column {
                Text("Auguste Conte", color = Color.White, modifier = Modifier.padding(start = 10.dp), fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)))
                Text("February 14, 2019", color = Color(0xFFFFFFFF).copy(alpha = 0.4f), modifier = Modifier.padding(start = 10.dp), fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)))

            }
        }
        Text("“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”",
            color = Color(0xFFA8ADB7),
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            fontFamily = FontFamily(Font(R.font.sk_modernist_regular))
        )
        Spacer(modifier = Modifier.height(10.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .padding(start = 35.dp, end = 35.dp)
            .background(color = Color(0xFF1A1F29)))
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(start = 24.dp, end = 24.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ellipse9),
                contentDescription = "ellipse9",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .height(36.dp)
                    .width(36.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Column {
                Text("Jang Marcelino", color = Color.White, modifier = Modifier.padding(start = 10.dp), fontSize = 16.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)))
                Text("February 14, 2019", color = Color(0xFFFFFFFF).copy(alpha = 0.4f), modifier = Modifier.padding(start = 10.dp), fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.sk_modernist_regular)))

            }
        }
        Text("“Once you start to learn its secrets, there’s a wild and exciting variety of play here that’s unmatched, even by its peers.”",
            color = Color(0xFFA8ADB7),
            modifier = Modifier.padding(start = 24.dp, end = 24.dp),
            fontFamily = FontFamily(Font(R.font.sk_modernist_regular)))
    }
}

@Composable
fun InstallButton() {
    val contextForToast = LocalContext.current.applicationContext
    Button(onClick = {
        Toast.makeText(contextForToast, "Installing, please wait...", Toast.LENGTH_SHORT).show()

    }, colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF4D144)), modifier = Modifier
        .height(64.dp)
        .fillMaxWidth()
        .padding(start = 24.dp, end = 24.dp, bottom = 6.dp),
        shape = RoundedCornerShape(20.dp))
    {
        Text("Install", color = Color(0xFF050B18), fontSize = 20.sp)
    }
}


@Preview
@Composable
fun PreviewProjectCard() {
    ProjectCard()
}