import 'dart:developer';
import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

class HomePage extends StatefulWidget {
  const HomePage({Key? key}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  static const channel = "EXPERIMENT";
  static const platform = MethodChannel(channel);

  void _openUnity() {
    try {
      final params = {
        "greeting": "i'm from flutter",
      };
      platform.invokeMethod("goToUnityActivity", params);
    } on PlatformException catch (e) {
      log("launch unity error: ${e.message}");
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: TextButton(
          onPressed: _openUnity,
          child: const Text("Open Unity"),
        ),
      ),
    );
  }
}
