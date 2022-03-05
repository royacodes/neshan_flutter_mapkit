package ir.allstarsoft.neshan_map_flutter

import android.content.Context
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory


class NeshanMapFactory(
    private val messenger: BinaryMessenger,
    lifecycleProvider: NeshanMapFlutterPlugin.LifecycleProvider
) :
    PlatformViewFactory(StandardMessageCodec.INSTANCE) {
    private val lifecycleProvider: NeshanMapFlutterPlugin.LifecycleProvider
    override fun create(context: Context, id: Int, args: Any): PlatformView {
        return NeshanMapController(
            id, context,
            messenger, args as Map<String?, Any?>, lifecycleProvider
        )
    }

    init {
        this.lifecycleProvider = lifecycleProvider
    }
}