package com.hifeelingsapp.hifeelings.ui.theme

import androidx.compose.foundation.Indication
import androidx.compose.foundation.IndicationInstance
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.ContentDrawScope
import androidx.compose.ui.Modifier
import androidx.compose.material3.NavigationBarItem

object NoIndication : Indication {

    @Composable
    override fun rememberUpdatedInstance(interactionSource: InteractionSource): IndicationInstance {
        return object : IndicationInstance {
            override fun ContentDrawScope.drawIndication() {
                // draw nothing, disables ripple
                drawContent()
            }
        }    }
}
