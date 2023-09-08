import type { HostComponent, ViewProps } from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';

import type { UnsafeMixed } from './codegenUtils';

export interface NativeProps extends ViewProps {
  sourceID?: string;
  reactStyle: UnsafeMixed;
}

export default codegenNativeComponent<NativeProps>(
  'MBXTerrain',
) as HostComponent<NativeProps>;