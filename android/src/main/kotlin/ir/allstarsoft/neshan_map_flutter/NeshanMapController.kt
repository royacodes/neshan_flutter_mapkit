package ir.allstarsoft.neshan_map_flutter

import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterFragmentActivity
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.platform.PlatformView
import org.neshan.mapsdk.MapView
import java.lang.ref.WeakReference


class NeshanMapController(
    id: Int,
    context: Context,
    messenger: BinaryMessenger?,
    params: Map<String?, Any?>,
    lifecycleProvider: NeshanMapFlutterPlugin.LifecycleProvider
) : PlatformView, MethodCallHandler, DefaultLifecycleObserver
//    UserLocationObjectListener, InputListener, CameraListener
{
    private var mapView: MapView? = null
    val context: Context
    val methodChannel: MethodChannel
    private val lifecycleProvider: NeshanMapFlutterPlugin.LifecycleProvider
//    private val userLocationLayer: UserLocationLayer?
//    private var userPinController: YandexPlacemarkController? = null
//    private var userArrowController: YandexPlacemarkController? = null
//    private var userAccuracyCircleController: YandexCircleController? = null
//    private val rootController: YandexMapObjectCollectionController
    private var disposed = false

    override fun getView(): View {
        return mapView!!
    }

    override fun onMethodCall(call: MethodCall, result: MethodChannel.Result) {
//        when (call.method) {
//            "waitForInit" -> result.success(null)
//            "toggleUserLayer" -> {
//                toggleUserLayer(call)
//                result.success(null)
//            }
//            "setMapStyle" -> result.success(setMapStyle(call))
//            "moveCamera" -> moveCamera(call, result)
//            "updateMapObjects" -> {
//                updateMapObjects(call)
//                result.success(null)
//            }
//            "updateMapOptions" -> {
//                updateMapOptions(call)
//                result.success(null)
//            }
//            "getMinZoom" -> {
//                val minZoom = minZoom
//                result.success(minZoom)
//            }
//            "getMaxZoom" -> {
//                val maxZoom = maxZoom
//                result.success(maxZoom)
//            }
//            "getPoint" -> result.success(getPoint(call))
//            "getScreenPoint" -> result.success(getScreenPoint(call))
//            "getCameraPosition" -> result.success(cameraPosition)
//            "getVisibleRegion" -> result.success(visibleRegion)
//            "getFocusRegion" -> result.success(focusRegion)
//            "getUserCameraPosition" -> result.success(userCameraPosition)
//            else -> result.notImplemented()
//        }
    }

//    fun updateMapObjects(call: MethodCall) {
//        val params = call.arguments as Map<String, Any>
//        applyMapObjects(params)
//    }
//
//    fun updateMapOptions(call: MethodCall) {
//        val params = call.arguments as Map<String, Any?>
//        applyMapOptions(params)
//    }
//
//    fun toggleUserLayer(call: MethodCall) {
//        if (!hasLocationPermission()) return
//        val params = call.arguments as Map<String, Any>
//        userLocationLayer.setVisible(params["visible"] as Boolean?)
//        userLocationLayer.setHeadingEnabled(params["headingEnabled"] as Boolean?)
//        userLocationLayer.setAutoZoomEnabled(params["autoZoomEnabled"] as Boolean?)
//    }
//
//    fun setMapStyle(call: MethodCall): Boolean {
//        val params = call.arguments as Map<String, Any>
//        return mapView.getMap().setMapStyle(params["style"] as String?)
//    }
//
//    val minZoom: Float
//        get() = mapView.getMap().getMinZoom()
//    val maxZoom: Float
//        get() = mapView.getMap().getMaxZoom()
//
//    fun getScreenPoint(call: MethodCall): Map<String, Float>? {
//        val params = call.arguments as Map<String, Any>
//        val screenPoint: ScreenPoint =
//            mapView.getMapWindow().worldToScreen(Utils.pointFromJson(params))
//        return if (screenPoint != null) {
//            Utils.screenPointToJson(screenPoint)
//        } else null
//    }
//
//    fun getPoint(call: MethodCall): Map<String, Double>? {
//        val params = call.arguments as Map<String, Any>
//        val point: Point = mapView.getMapWindow().screenToWorld(Utils.screenPointFromJson(params))
//        return if (point != null) {
//            Utils.pointToJson(point)
//        } else null
//    }
//
//    fun moveCamera(call: MethodCall, result: MethodChannel.Result) {
//        val params = call.arguments as Map<String, Any>
//        move(
//            cameraUpdateToPosition(params["cameraUpdate"] as Map<String, Any>?),
//            params["animation"] as Map<String, Any>?,
//            result
//        )
//    }
//
//    val cameraPosition: Map<String, Any>
//        get() {
//            val arguments: MutableMap<String, Any> = HashMap()
//            arguments["cameraPosition"] =
//                Utils.cameraPositionToJson(mapView.getMapWindow().getMap().getCameraPosition())
//            return arguments
//        }
//    val userCameraPosition: Map<String, Any>?
//        get() {
//            if (!hasLocationPermission()) return null
//            if (userLocationLayer != null) {
//                val cameraPosition: CameraPosition = userLocationLayer.cameraPosition()
//                if (cameraPosition != null) {
//                    val arguments: MutableMap<String, Any> = HashMap()
//                    arguments["cameraPosition"] = Utils.cameraPositionToJson(cameraPosition)
//                    return arguments
//                }
//            }
//            return null
//        }
//    val visibleRegion: Map<String, Any>
//        get() {
//            val arguments: MutableMap<String, Any> = HashMap()
//            arguments["visibleRegion"] =
//                Utils.visibleRegionToJson(mapView.getMap().getVisibleRegion())
//            return arguments
//        }
//    val focusRegion: Map<String, Any>
//        get() {
//            val arguments: MutableMap<String, Any> = HashMap()
//            arguments["focusRegion"] =
//                Utils.visibleRegionToJson(mapView.getMapWindow().getFocusRegion())
//            return arguments
//        }
//
//    private fun hasLocationPermission(): Boolean {
//        val permissionState = ActivityCompat.checkSelfPermission(
//            context,
//            Manifest.permission.ACCESS_FINE_LOCATION
//        )
//        return permissionState == PackageManager.PERMISSION_GRANTED
//    }
//
//    private fun cameraUpdateToPosition(cameraUpdate: Map<String, Any>?): CameraPosition {
//        val cameraUpdateParams = cameraUpdate!!["params"] as Map<String, Any>?
//        return when (cameraUpdate["type"] as String?) {
//            "newCameraPosition" -> newCameraPosition(cameraUpdateParams)
//            "newBounds" -> newBounds(cameraUpdateParams)
//            "newTiltAzimuthBounds" -> newTiltAzimuthBounds(cameraUpdateParams)
//            "zoomIn" -> zoomIn()
//            "zoomOut" -> zoomOut()
//            "zoomTo" -> zoomTo(cameraUpdateParams)
//            "azimuthTo" -> azimuthTo(cameraUpdateParams)
//            "tiltTo" -> tiltTo(cameraUpdateParams)
//            else -> CameraPosition()
//        }
//    }
//
//    fun newCameraPosition(params: Map<String, Any>?): CameraPosition {
//        val paramsCameraPosition = params!!["cameraPosition"] as Map<String, Any>?
//        return CameraPosition(
//            Utils.pointFromJson(paramsCameraPosition!!["target"] as Map<String?, Any?>?),
//            (paramsCameraPosition["zoom"] as Double?)!!.toFloat(),
//            (paramsCameraPosition["azimuth"] as Double?)!!.toFloat(),
//            (paramsCameraPosition["tilt"] as Double?)!!.toFloat()
//        )
//    }
//
//    fun newBounds(params: Map<String, Any>?): CameraPosition {
//        return mapView.getMap()
//            .cameraPosition(Utils.boundingBoxFromJson(params!!["boundingBox"] as Map<String?, Any?>?))
//    }
//
//    fun newTiltAzimuthBounds(params: Map<String, Any>?): CameraPosition {
//        return mapView.getMap().cameraPosition(
//            Utils.boundingBoxFromJson(params!!["boundingBox"] as Map<String?, Any?>?),
//            (params["azimuth"] as Double?)!!.toFloat(),
//            (params["tilt"] as Double?)!!.toFloat()
//        )
//    }
//
//    private fun zoomIn(): CameraPosition {
//        val curPosition: CameraPosition = mapView.getMap().getCameraPosition()
//        return CameraPosition(
//            curPosition.getTarget(),
//            curPosition.getZoom() + 1,
//            curPosition.getAzimuth(),
//            curPosition.getTilt()
//        )
//    }
//
//    private fun zoomOut(): CameraPosition {
//        val curPosition: CameraPosition = mapView.getMap().getCameraPosition()
//        return CameraPosition(
//            curPosition.getTarget(),
//            curPosition.getZoom() - 1,
//            curPosition.getAzimuth(),
//            curPosition.getTilt()
//        )
//    }
//
//    fun zoomTo(params: Map<String, Any>?): CameraPosition {
//        val curPosition: CameraPosition = mapView.getMap().getCameraPosition()
//        return CameraPosition(
//            curPosition.getTarget(),
//            (params!!["zoom"] as Double?)!!.toFloat(),
//            curPosition.getAzimuth(),
//            curPosition.getTilt()
//        )
//    }
//
//    fun azimuthTo(params: Map<String, Any>?): CameraPosition {
//        val curPosition: CameraPosition = mapView.getMap().getCameraPosition()
//        return CameraPosition(
//            curPosition.getTarget(),
//            curPosition.getZoom(),
//            (params!!["azimuth"] as Double?)!!.toFloat(),
//            curPosition.getTilt()
//        )
//    }
//
//    fun tiltTo(params: Map<String, Any>?): CameraPosition {
//        val curPosition: CameraPosition = mapView.getMap().getCameraPosition()
//        return CameraPosition(
//            curPosition.getTarget(),
//            curPosition.getZoom(),
//            curPosition.getAzimuth(),
//            (params!!["tilt"] as Double?)!!.toFloat()
//        )
//    }
//
//    private fun move(
//        cameraPosition: CameraPosition,
//        paramsAnimation: Map<String, Any>?,
//        result: MethodChannel.Result
//    ) {
//        if (paramsAnimation == null) {
//            mapView.getMap().move(cameraPosition)
//            result.success(true)
//            return
//        }
//        val type: Animation.Type = Animation.Type.values().get(paramsAnimation["type"] as Int?)
//        val animation = Animation(type, (paramsAnimation["duration"] as Double?)!!.toFloat())
//        mapView.getMap().move(
//            cameraPosition,
//            animation,
//            object : CameraCallback() {
//                fun onMoveFinished(completed: Boolean) {
//                    result.success(completed)
//                }
//            }
//        )
//    }
//
//    private fun applyMapOptions(params: Map<String, Any?>?) {
//        val map: com.yandex.mapkit.map.Map = mapView.getMap()
//        if (params!!["tiltGesturesEnabled"] != null) {
//            map.setTiltGesturesEnabled(params["tiltGesturesEnabled"] as Boolean?)
//        }
//        if (params["zoomGesturesEnabled"] != null) {
//            map.setZoomGesturesEnabled(params["zoomGesturesEnabled"] as Boolean?)
//        }
//        if (params["rotateGesturesEnabled"] != null) {
//            map.setRotateGesturesEnabled(params["rotateGesturesEnabled"] as Boolean?)
//        }
//        if (params["nightModeEnabled"] != null) {
//            map.setNightModeEnabled(params["nightModeEnabled"] as Boolean?)
//        }
//        if (params["scrollGesturesEnabled"] != null) {
//            map.setScrollGesturesEnabled(params["scrollGesturesEnabled"] as Boolean?)
//        }
//        if (params["fastTapEnabled"] != null) {
//            map.setFastTapEnabled(params["fastTapEnabled"] as Boolean?)
//        }
//        if (params["mode2DEnabled"] != null) {
//            map.set2DMode(params["mode2DEnabled"] as Boolean?)
//        }
//        if (params["indoorEnabled"] != null) {
//            map.setIndoorEnabled(params["indoorEnabled"] as Boolean?)
//        }
//        if (params["liteModeEnabled"] != null) {
//            map.setLiteModeEnabled(params["liteModeEnabled"] as Boolean?)
//        }
//        if (params["modelsEnabled"] != null) {
//            map.setModelsEnabled(params["modelsEnabled"] as Boolean?)
//        }
//        if (params["logoAlignment"] != null) {
//            applyAlignLogo(params["logoAlignment"] as Map<String, Any>?)
//        }
//        if (params.containsKey("screenRect")) {
//            applyScreenRect(params["screenRect"] as Map<String, Any>?)
//        }
//    }
//
//    private fun applyMapObjects(params: Map<String, Any>?) {
//        val toChangeParams = params!!["toChange"] as List<Map<String, Any>>?
//        for (toChangeParam in toChangeParams!!) {
//            if (toChangeParam["id"] == rootController.id) {
//                rootController.update(toChangeParam)
//            }
//        }
//    }
//
//    private fun applyAlignLogo(params: Map<String, Any>?) {
//        val logoPosition = Alignment(
//            HorizontalAlignment.values().get(params!!["horizontal"] as Int?),
//            VerticalAlignment.values().get(params["vertical"] as Int?)
//        )
//        mapView.getMap().getLogo().setAlignment(logoPosition)
//    }
//
//    private fun applyScreenRect(params: Map<String, Any>?) {
//        if (params == null) {
//            mapView.setFocusRect(null)
//            mapView.setPointOfView(PointOfView.SCREEN_CENTER)
//            return
//        }
//        val screenRect = ScreenRect(
//            Utils.screenPointFromJson(params["topLeft"] as Map<String?, Any?>?),
//            Utils.screenPointFromJson(params["bottomRight"] as Map<String?, Any?>?)
//        )
//        mapView.setFocusRect(screenRect)
//        mapView.setPointOfView(PointOfView.ADAPT_TO_FOCUS_RECT_HORIZONTALLY)
//    }
//
//    fun onObjectAdded(view: UserLocationView) {
//        val self = this
//        val arguments: MutableMap<String, Any> = HashMap()
//        arguments["pinPoint"] = Utils.pointToJson(view.getPin().getGeometry())
//        arguments["arrowPoint"] = Utils.pointToJson(view.getArrow().getGeometry())
//        arguments["circle"] = Utils.circleToJson(view.getAccuracyCircle().getGeometry())
//        methodChannel.invokeMethod("onUserLocationAdded", arguments, object : MethodChannel.Result {
//            override fun success(result: Any?) {
//                val params = result as Map<String, Any>?
//                if (!view.isValid()) {
//                    return
//                }
//                userPinController = YandexPlacemarkController(
//                    view.getPin().getParent(),
//                    view.getPin(),
//                    params!!["pin"] as Map<String?, Any?>?,
//                    WeakReference(self)
//                )
//                userArrowController = YandexPlacemarkController(
//                    view.getArrow().getParent(),
//                    view.getArrow(),
//                    params!!["arrow"] as Map<String?, Any?>?,
//                    WeakReference(self)
//                )
//                userAccuracyCircleController = YandexCircleController(
//                    view.getAccuracyCircle(),
//                    params!!["accuracyCircle"] as Map<String?, Any?>?,
//                    WeakReference(self)
//                )
//            }
//
//            override fun error(errorCode: String, errorMessage: String?, errorDetails: Any?) {}
//            override fun notImplemented() {}
//        })
//    }
//
//    fun onObjectRemoved(view: UserLocationView) {}
//    fun onObjectUpdated(view: UserLocationView, event: ObjectEvent) {}
//    fun onCameraPositionChanged(
//        map: com.yandex.mapkit.map.Map,
//        cameraPosition: CameraPosition,
//        cameraUpdateReason: CameraUpdateReason,
//        finished: Boolean
//    ) {
//        val arguments: MutableMap<String, Any> = HashMap()
//        arguments["cameraPosition"] = Utils.cameraPositionToJson(cameraPosition)
//        arguments["reason"] = cameraUpdateReason.ordinal()
//        arguments["finished"] = finished
//        methodChannel.invokeMethod("onCameraPositionChanged", arguments)
//    }
//
//    fun onMapTap(map: com.yandex.mapkit.map.Map, point: Point) {
//        val arguments: MutableMap<String, Any> = HashMap()
//        arguments["point"] = Utils.pointToJson(point)
//        methodChannel.invokeMethod("onMapTap", arguments)
//    }
//
//    fun onMapLongTap(map: com.yandex.mapkit.map.Map, point: Point) {
//        val arguments: MutableMap<String, Any> = HashMap()
//        arguments["point"] = Utils.pointToJson(point)
//        methodChannel.invokeMethod("onMapLongTap", arguments)
//    }
//
//    fun mapObjectDragStart(id: String) {
//        val arguments: MutableMap<String, Any> = HashMap()
//        arguments["id"] = id
//        methodChannel.invokeMethod("onMapObjectDragStart", arguments)
//    }
//
//    fun mapObjectDrag(id: String, point: Point) {
//        val arguments: MutableMap<String, Any> = HashMap()
//        arguments["id"] = id
//        arguments["point"] = Utils.pointToJson(point)
//        methodChannel.invokeMethod("onMapObjectDrag", arguments)
//    }
//
//    fun mapObjectDragEnd(id: String) {
//        val arguments: MutableMap<String, Any> = HashMap()
//        arguments["id"] = id
//        methodChannel.invokeMethod("onMapObjectDragEnd", arguments)
//    }
//
//    fun mapObjectTap(id: String, point: Point) {
//        val arguments: MutableMap<String, Any> = HashMap()
//        arguments["id"] = id
////        arguments["point"] = Utils.pointToJson(point)
//        methodChannel.invokeMethod("onMapObjectTap", arguments)
//    }
//
    override fun dispose() {
        if (disposed) {
            return
        }
        disposed = true
        methodChannel.setMethodCallHandler(null)
        val lifecycle: Lifecycle? = lifecycleProvider.getLifecycle()
        if (lifecycle != null) {
            lifecycle.removeObserver(this)
        }
    }

    override fun onCreate(owner: LifecycleOwner) {}
    override fun onStart(owner: LifecycleOwner) {
        if (disposed) {
            return
        }
//        mapView.onStart()
    }

    override fun onResume(owner: LifecycleOwner) {}
    override fun onPause(owner: LifecycleOwner) {}
    override fun onStop(owner: LifecycleOwner) {
        if (disposed) {
            return
        }
//        mapView.onStop()
    }

    override fun onDestroy(owner: LifecycleOwner) {
        owner.lifecycle.removeObserver(this)
    }

    init {
        this.lifecycleProvider = lifecycleProvider
        this.context = context
        if (context is FlutterActivity) {
            mapView = LayoutInflater.from(context).inflate(ir.allstarsoft.neshan_map_flutter.R.layout.map_view, null) as MapView
        } else if (context is FlutterFragmentActivity) {
            mapView = LayoutInflater.from(context).inflate(ir.allstarsoft.neshan_map_flutter.R.layout.map_view, null) as MapView
        } else {
            mapView = MapView(context)
        }
//        mapView.onStart()
//        userLocationLayer =
//            MapKitFactory.getInstance().createUserLocationLayer(mapView.getMapWindow())
        methodChannel = MethodChannel(messenger, "neshan_mapkit/nehan_map_$id")
        methodChannel.setMethodCallHandler(this)
//        rootController = YandexMapObjectCollectionController(
//            mapView.getMap().getMapObjects(),
//            "root_map_object_collection",
//            WeakReference(this)
//        )
//        mapView.getMap().addInputListener(this)
//        mapView.getMap().addCameraListener(this)
//        lifecycleProvider.getLifecycle().addObserver(this)
//        userLocationLayer.setObjectListener(this)
//        applyMapOptions(params["mapOptions"] as Map<String, Any?>?)
//        applyMapObjects(params["mapObjects"] as Map<String, Any>?)
    }
}


