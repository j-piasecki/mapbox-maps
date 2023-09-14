import MapboxMaps

@objc
public class MBXVectorSource : RCTMGLTileSource {
  
  @objc public var attribution: String?
  @objc public var maxZoomLevel: NSNumber?
  @objc public var minZoomLevel: NSNumber?
  @objc public var tileUrlTemplates: [String] = []
  @objc public var tms: Bool = false
  
  override func sourceType() -> Source.Type {
    return VectorSource.self
  }

  override func makeSource() -> Source
  {
    var result = VectorSource()
    if let url = url {
      result.url = url
    } else {
      result.tiles = tileUrlTemplates
    }
    if let attribution = attribution {
      result.attribution = attribution
    }
    if let maxZoomLevel = maxZoomLevel {
      result.maxzoom = maxZoomLevel.doubleValue
    }
    if let minZoomLevel = minZoomLevel {
      result.minzoom = minZoomLevel.doubleValue
    }
    if tms {
      result.scheme = .tms
    }
    return result
  }
  
  
  
  /*
  - (nullable MGLSource*)makeSource
{
    if (self.url != nil) {
        return [[MGLVectorTileSource alloc] initWithIdentifier:self.id configurationURL:[NSURL URLWithString:self.url]];
    }
    return [[MGLVectorTileSource alloc] initWithIdentifier:self.id tileURLTemplates:self.tileUrlTemplates options:[self getOptions]];
}

- (nonnull NSArray<id <MGLFeature>> *)featuresInSourceLayersWithIdentifiers:(nonnull NSSet<NSString *> *)sourceLayerIdentifiers predicate:(nullable NSPredicate *)predicate
{
    MGLVectorTileSource* vectorSource = (MGLVectorTileSource*)self.source;
    
    return [vectorSource featuresInSourceLayersWithIdentifiers:sourceLayerIdentifiers predicate: predicate];
}*/

}
