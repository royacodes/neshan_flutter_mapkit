#import "NeshanMapFlutterPlugin.h"
#if __has_include(<neshan_map_flutter/neshan_map_flutter-Swift.h>)
#import <neshan_map_flutter/neshan_map_flutter-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "neshan_map_flutter-Swift.h"
#endif

@implementation NeshanMapFlutterPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftNeshanMapFlutterPlugin registerWithRegistrar:registrar];
}
@end
