
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
  static const String _viewType = 'neshan_mapkit/neshan_map';
  var gestureRecognizers = const <Factory<OneSequenceGestureRecognizer>>{};
  @override
  Widget build(BuildContext context) {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return PlatformViewLink(
          viewType: _viewType,
          surfaceFactory: (BuildContext context, PlatformViewController controller) {
            return AndroidViewSurface(
              controller: controller as AndroidViewController,
              gestureRecognizers: gestureRecognizers,
              hitTestBehavior: PlatformViewHitTestBehavior.opaque,
            );
          },
          onCreatePlatformView: (PlatformViewCreationParams params) {
            return PlatformViewsService.initSurfaceAndroidView(
              id: params.id,
              viewType: _viewType,
              layoutDirection: TextDirection.ltr,
              // creationParams: _creationParams(),
              creationParamsCodec: StandardMessageCodec(),
              onFocus: () => params.onFocusChanged(true),
            )
              ..addOnPlatformViewCreatedListener(params.onPlatformViewCreated)
              ..addOnPlatformViewCreatedListener(_onPlatformViewCreated)
              ..create();
          }
      );
    }
    return Text(
        '$defaultTargetPlatform is not yet supported by the text_view plugin');
  }

  void _onPlatformViewCreated(int id) {

  }
}
