package com.example.first_ar_app

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.isGone
import com.example.first_ar_app.ui.theme.First_ar_appTheme
import com.google.ar.sceneform.math.Vector3
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import dev.romainguy.kotlin.math.Float3
import io.github.sceneview.ar.ArSceneView
import io.github.sceneview.ar.localPosition
import io.github.sceneview.ar.node.ArModelNode
import io.github.sceneview.math.Position
import com.google.ar.sceneform.math.Vector3 as MathVector3
import kotlin.random.Random as Random1


class MainActivity : ComponentActivity() {

    private lateinit var sceneView: ArSceneView
    private lateinit var placeButton: Button
    private lateinit var  modelNode: ArModelNode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        sceneView = findViewById(R.id.sceneView)
        placeButton = findViewById((R.id.place))

        placeButton.setOnClickListener {
            placeModel()
        }

        modelNode = ArModelNode().apply { loadModelGlbAsync(
            glbFileLocation = "balloon.glb"
        )

        {
            sceneView.planeRenderer.isVisible = true
        }
            onAnchorChanged = {
                placeButton.isGone
            }
        }
        sceneView.addChild(modelNode)

    }


    private fun placeModel(){
            modelNode.anchor()
            sceneView.planeRenderer.isVisible = false
        modelNode.setScale(0.3f)


        }
}


