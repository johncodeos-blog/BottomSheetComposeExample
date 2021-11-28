package com.example.bottomsheetcomposeexample

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomSheetContent() {
    val context = LocalContext.current
    Column {
        BottomSheetListItem(
            icon = R.drawable.ic_share,
            title = "Share",
            onItemClick = { title ->
                Toast.makeText(
                    context,
                    title,
                    Toast.LENGTH_SHORT
                ).show()
            })
        BottomSheetListItem(
            icon = R.drawable.ic_link,
            title = "Get link",
            onItemClick = { title ->
                Toast.makeText(
                    context,
                    title,
                    Toast.LENGTH_SHORT
                ).show()
            })
        BottomSheetListItem(
            icon = R.drawable.ic_edit,
            title = "Edit name",
            onItemClick = { title ->
                Toast.makeText(
                    context,
                    title,
                    Toast.LENGTH_SHORT
                ).show()
            })
        BottomSheetListItem(
            icon = R.drawable.ic_delete,
            title = "Delete collection",
            onItemClick = { title ->
                Toast.makeText(
                    context,
                    title,
                    Toast.LENGTH_SHORT
                ).show()
            })
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetContentPreview() {
    BottomSheetContent()
}

@Composable
fun BottomSheetListItem(icon: Int, title: String, onItemClick: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = { onItemClick(title) })
            .height(55.dp)
            .background(color = colorResource(id = R.color.colorPrimary))
            .padding(start = 15.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = "Share", tint = Color.White)
        Spacer(modifier = Modifier.width(20.dp))
        Text(text = title, color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun BottomSheetListItemPreview() {
    BottomSheetListItem(icon = R.drawable.ic_share, title = "Share", onItemClick = { })
}