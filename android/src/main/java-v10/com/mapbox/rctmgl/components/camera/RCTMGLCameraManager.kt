package com.mapbox.rctmgl.components.camera
import com.facebook.react.bridge.Dynamic
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.MBXCameraManagerInterface
import com.mapbox.geojson.FeatureCollection
import com.mapbox.rctmgl.components.AbstractEventEmitter
import com.mapbox.rctmgl.components.camera.CameraStop.Companion.fromReadableMap
import com.mapbox.rctmgl.utils.GeoJSONUtils.toLatLngBounds


class RCTMGLCameraManager(private val mContext: ReactApplicationContext) :
    AbstractEventEmitter<RCTMGLCamera?>(
        mContext
    ), MBXCameraManagerInterface<RCTMGLCamera> {
    override fun customEvents(): Map<String, String>? {
        return HashMap()
    }

    override fun getName(): String {
        return REACT_CLASS
    }

    override fun createViewInstance(reactContext: ThemedReactContext): RCTMGLCamera {
        return RCTMGLCamera(reactContext, this)
    }

    @ReactProp(name = "stop")
    override fun setStop(camera: RCTMGLCamera, map: ReadableMap?) {
        if (map != null) {
            val stop = fromReadableMap(mContext, map, null)
            camera.setStop(stop)
        }
    }

    @ReactProp(name = "defaultStop")
    override fun setDefaultStop(camera: RCTMGLCamera, map: ReadableMap?) {
        if (map != null) {
            val stop = fromReadableMap(mContext, map, null)
            camera.setDefaultStop(stop)
        }
    }

    @ReactProp(name = "userTrackingMode")
    override fun setUserTrackingMode(camera: RCTMGLCamera, userTrackingMode: Int) {
        camera.setUserTrackingMode(userTrackingMode)
        throw AssertionError("Unused code")
    }

    @ReactProp(name = "zoomLevel")
    override fun setZoomLevel(camera: RCTMGLCamera, zoomLevel: Double) {
        camera.setZoomLevel(zoomLevel)
    }

    @ReactProp(name = "minZoomLevel")
    override fun setMinZoomLevel(camera: RCTMGLCamera, value: Double) {
        camera.setMinZoomLevel(value)
    }

    @ReactProp(name = "maxZoomLevel")
    override fun setMaxZoomLevel(camera: RCTMGLCamera, value: Double) {
        camera.setMaxZoomLevel(value)
    }

    @ReactProp(name = "followUserLocation")
    override fun setFollowUserLocation(camera: RCTMGLCamera, value: Boolean) {
        camera.setFollowUserLocation(value)
    }

    @ReactProp(name = "followUserMode")
    override fun setFollowUserMode(camera: RCTMGLCamera, value: String?) {
        camera.setFollowUserMode(value)
    }

    @ReactProp(name = "followZoomLevel")
    override fun setFollowZoomLevel(camera: RCTMGLCamera, value: Double) {
        camera.setFollowZoomLevel(value)
    }

    @ReactProp(name = "followPitch")
    override fun setFollowPitch(camera: RCTMGLCamera, value: Double) {
        camera.setFollowPitch(value)
    }

    @ReactProp(name = "followHeading")
    override fun setFollowHeading(camera: RCTMGLCamera, value: Double) {
        camera.setFollowHeading(value)
    }

    @ReactProp(name = "followPadding")
    override fun setFollowPadding(camera: RCTMGLCamera, value: Dynamic) {
        camera.setFollowPadding(value.asMap())
    }

    @ReactProp(name = "maxBounds")
    override fun setMaxBounds(camera: RCTMGLCamera, value: String?) {
        if (value != null) {
            val collection = FeatureCollection.fromJson(value)
            camera.setMaxBounds(toLatLngBounds(collection))
        } else {
            camera.setMaxBounds(null)
        }
    }

    override fun setAnimationDuration(view: RCTMGLCamera?, value: Double) {
        // no-op on Android
    }

    override fun setAnimationMode(view: RCTMGLCamera?, value: String?) {
        // no-op on Android
    }

    companion object {
        const val REACT_CLASS = "MBXCamera"
    }
}