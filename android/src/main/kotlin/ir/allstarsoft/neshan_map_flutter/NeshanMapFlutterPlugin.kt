package ir.allstarsoft.neshan_map_flutter

import android.content.Context;

import androidx.annotation.NonNull
import androidx.annotation.Nullable
import androidx.lifecycle.Lifecycle

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
//import io.flutter.embedding.engine.plugins.lifecycle.FlutterLifecycleAdapter
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodChannel;

class NeshanMapFlutterPlugin : FlutterPlugin, ActivityAware {
  companion object {
    private val VIEW_TYPE = "neshan_mapkit/neshan_map"
  }

  @Nullable
  private var lifecycle: Lifecycle? = null

  override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
//    MapKitFactory.initialize(binding.applicationContext)

    val messenger = binding.binaryMessenger
    binding.platformViewRegistry.registerViewFactory(
      VIEW_TYPE,
      NeshanMapFactory(messenger, LifecycleProvider())
    )

    setupChannels(messenger, binding.applicationContext)
  }

  private fun setupChannels(messenger: BinaryMessenger, context: Context) {
//    searchMethodChannel = MethodChannel(messenger, SEARCH_CHANNEL_ID)
//    val yandexSearch = YandexSearch(context, messenger)
//    searchMethodChannel.setMethodCallHandler(yandexSearch)
//    suggestMethodChannel = MethodChannel(messenger, SUGGEST_CHANNEL_ID)
//    val yandexSuggest = YandexSuggest(context, messenger)
//    suggestMethodChannel.setMethodCallHandler(yandexSuggest)
//    drivingRouterMethodChannel = MethodChannel(messenger, DRIVING_CHANNEL_ID)
//    val yandexDriving = YandexDriving(context, messenger)
//    drivingRouterMethodChannel.setMethodCallHandler(yandexDriving)
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    teardownChannels()
  }

  private fun teardownChannels() {
//    searchMethodChannel.setMethodCallHandler(null)
//    searchMethodChannel = null
//    suggestMethodChannel.setMethodCallHandler(null)
//    suggestMethodChannel = null
//    drivingRouterMethodChannel.setMethodCallHandler(null)
//    drivingRouterMethodChannel = null
  }

  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
//    lifecycle = FlutterLifecycleAdapter.getActivityLifecycle(binding);
//    MapKitFactory.getInstance().onStart();
  }

  override fun onDetachedFromActivityForConfigChanges() {
    onDetachedFromActivity()
  }

  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    onAttachedToActivity(binding)
  }

  override fun onDetachedFromActivity() {
    lifecycle = null;
//    MapKitFactory.getInstance().onStop();
  }

  inner class LifecycleProvider {
    fun getLifecycle(): Lifecycle? {
      return lifecycle
    }
  }

}
