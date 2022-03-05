package ir.allstarsoft.neshan_map_flutter

import io.flutter.plugin.common.PluginRegistry.Registrar


/** NeshanMapFlutterPlugin */
class NeshanMapFlutterPlugin {
  companion object {
    fun registerWith(registrar: Registrar) {
      registrar
        .platformViewRegistry()
        .registerViewFactory(
          "neshan-map", NativeViewFactory(registrar.messenger())
        )
    }
  }

}
