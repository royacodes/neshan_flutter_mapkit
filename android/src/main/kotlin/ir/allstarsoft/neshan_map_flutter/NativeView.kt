package ir.allstarsoft.neshan_map_flutter

import android.content.Context
import android.view.View
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.platform.PlatformView
import org.neshan.mapsdk.MapView


class NativeView(context: Context,  messenger : BinaryMessenger, id: Int) : PlatformView,
    MethodChannel.MethodCallHandler {

    private val mapView: MapView
    private val methodChannel: MethodChannel


     override fun getView(): View {
        return mapView
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {

    }

    override fun dispose() {}

    init {
        mapView = MapView(context)
        methodChannel = MethodChannel(messenger, "neshan-map_$id")
        methodChannel.setMethodCallHandler(this)
    }
}


