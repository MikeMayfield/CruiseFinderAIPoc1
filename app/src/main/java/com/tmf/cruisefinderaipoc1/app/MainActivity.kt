package com.tmf.cruisefinderaipoc1.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.R
import com.tmf.cruisefinderaipoc1.customControls.ScreenLayout
import com.tmf.cruisefinderaipoc1.models.BoundData
import com.tmf.cruisefinderaipoc1.models.Layout
import com.tmf.cruisefinderaipoc1.models.LiveData
import com.tmf.cruisefinderaipoc1.testdata.testBoundData
import com.tmf.cruisefinderaipoc1.testdata.testSearchScreenLayout
import com.tmf.cruisefinderaipoc1.ui.theme.CruiseFinderAIPoc1Theme
import kotlinx.serialization.json.Json.Default.decodeFromString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //TODO: Get from ViewModel and make observable
        val screenLayout = decodeFromString<Layout>(testSearchScreenLayout)  //TODO Get layout from repository
        LiveData.searchBoundData = decodeFromString<BoundData>(testBoundData)  //TODO Get data from repository
        LiveData.boundData = LiveData.searchBoundData  //TODO set this in Navigation control for Search

        setContent {
            CruiseFinderAIPoc1Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxWidth(),
                    color = Black
                    ) {// MaterialTheme.colorScheme.background) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(5.dp)
                            .verticalScroll(rememberScrollState())
                            .paint(
                                painter = painterResource(R.drawable.background),
                                contentScale = ContentScale.FillBounds
                            ),
                        ) {
                        ScreenLayout(layout = screenLayout, boundData = LiveData.searchBoundData)
                    }
                }
            }
        }
    }
}
