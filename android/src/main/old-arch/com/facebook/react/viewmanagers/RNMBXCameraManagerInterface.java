/**
* This code was generated by [react-native-codegen](https://www.npmjs.com/package/react-native-codegen).
*
* Do not edit this file as changes may cause incorrect behavior and will be lost
* once the code is regenerated.
*
* @generated by codegen project: GeneratePropsJavaInterface.js
*/

package com.facebook.react.viewmanagers;

import android.view.View;
import androidx.annotation.Nullable;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.ReadableMap;

public interface RNMBXCameraManagerInterface<T extends View> {
  void setMaxBounds(T view, @Nullable String value);
  void setAnimationDuration(T view, double value);
  void setAnimationMode(T view, @Nullable String value);
  void setDefaultStop(T view, @Nullable ReadableMap value);
  void setUserTrackingMode(T view, int value);
  void setFollowUserLocation(T view, boolean value);
  void setFollowUserMode(T view, @Nullable String value);
  void setFollowZoomLevel(T view, double value);
  void setFollowPitch(T view, double value);
  void setFollowHeading(T view, double value);
  void setFollowPadding(T view, Dynamic value);
  void setZoomLevel(T view, double value);
  void setMaxZoomLevel(T view, double value);
  void setMinZoomLevel(T view, double value);
  void setStop(T view, @Nullable ReadableMap value);
}
