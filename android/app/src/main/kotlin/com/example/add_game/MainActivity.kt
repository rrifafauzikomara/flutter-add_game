package com.example.add_game

import io.flutter.embedding.android.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.plugins.util.GeneratedPluginRegister

import android.content.Intent
import android.os.Bundle

class MainActivity: FlutterActivity() {
     private val methodChannel = "EXPERIMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        GeneratedPluginRegister.registerGeneratedPlugins(FlutterEngine(this@MainActivity))
        flutterEngine?.dartExecutor?.let {
            MethodChannel(it, methodChannel).setMethodCallHandler{ call, result ->
                if (call.method.equals("goToUnityActivity")) {
                    val arg = call.arguments as Map<String, Any>
                    val message = arg.getValue("greeting") as String
                    goToUnityActivity(message)
                    result.success(null)
                } else {
                    result.notImplemented()
                }
            }
        }
    }

    private fun goToUnityActivity(message: String){
        val intent = Intent(this, MainUnityActivity::class.java)
        intent.putExtra("greeting", message);
        startActivity(intent)
    }
}