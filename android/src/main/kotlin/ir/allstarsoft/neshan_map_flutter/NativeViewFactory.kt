package ir.allstarsoft.neshan_map_flutter


import android.content.Context
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory

class NativeViewFactory(private val messenger: BinaryMessenger) : PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    private val messenger1: BinaryMessenger = messenger

    override fun create(context: Context, viewId: Int, args: Any?): PlatformView {
        return NativeView(context, messenger1, viewId)
    }
}