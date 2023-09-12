package com.tmf.cruisefinderaipoc1.screens.search

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tmf.cruisefinderaipoc1.ui.theme.CruiseFinderAIPoc1Theme

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onClose: () -> Unit
) {

    Column(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Group(label = "Travelers: ") {
//            TextInput()
//            TextInput()
        }
    }

}

@Composable
fun Group(
    label: String,
    content: @Composable() () -> Unit
) {

}

@Composable
fun TextInput(
    label: String,
    text: String = "",  //Replace {{boundValue}} and/or {{dynamicValue}}, if present
    onValueChange: (newValue: String) -> Unit,
    placeholder: String = "",
    boundValueID: Int = 0,
    maxLines: Int = Int.MAX_VALUE,
    modifier: Modifier = Modifier
) {
    Card(  //TODO Add expand/contract icon at right edge and support expanding on click
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = RoundedCornerShape(6.dp),
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxWidth()
            .padding(5.dp, 5.dp, 5.dp, 5.dp)
    ) {

        Column(modifier = modifier.fillMaxWidth().padding(6.dp)) {
            val isExpanded = remember { mutableStateOf(true) }  //TODO Initially false

            //Label + text at top of card
            var boundValue = ""  //Get from bound values collection
            var dynamicValue = boundValue
            Text(text = label + text.replace("{{boundValue}}", boundValue).replace("{{dynamicValue}}", dynamicValue),
                maxLines = maxLines,
                overflow = TextOverflow.Ellipsis,
                modifier = modifier
                    .fillMaxWidth()
                    .clickable {
                        isExpanded.value = !isExpanded.value
                    }
                )

            //Input box, shown when expanded
            if (isExpanded.value) {
                BasicTextField(
                    value = boundValue,
                    onValueChange = {
                        boundValue = it//TODO Update bound value
                        onValueChange(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .padding(start = 20.dp)
                        .clip(RoundedCornerShape(5.dp))
                        .background(White)
                        .padding(6.dp),
                    decorationBox = { innerTextField ->
                        Box {
                            if (boundValue.isEmpty()) {
                                Text(
                                    text = placeholder,
                                    color = LightGray,
                                    fontStyle = FontStyle.Italic
                                )
                            }
                            innerTextField()
                        }
                    }

                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CruiseFinderAIPoc1Theme {
        Surface(modifier = Modifier.fillMaxWidth(), color = Black) {
            TextInput(label = "Test", placeholder = "Enter value", onValueChange = {})
        }
    }
}
