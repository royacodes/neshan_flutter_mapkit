
import 'dart:async';

import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/rendering.dart';
import 'package:flutter/services.dart';
import 'package:flutter/material.dart';





class NeshanMapFlutter extends StatefulWidget {
  const NeshanMapFlutter({
    Key? key,
  }) : super(key: key);


  @override
  _NeshanMapFlutterState createState() => _NeshanMapFlutterState();
}

class _NeshanMapFlutterState extends State<NeshanMapFlutter> {
  @override
  Widget build(BuildContext context) {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return AndroidView(
        viewType: 'neshan-map',
        onPlatformViewCreated: _onPlatformViewCreated,
      );
    }
    return Text(
        '$defaultTargetPlatform is not yet supported by the text_view plugin');
  }

  void _onPlatformViewCreated(int id) {

  }
}
