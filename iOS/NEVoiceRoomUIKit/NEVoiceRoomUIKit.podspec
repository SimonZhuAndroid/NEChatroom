# Copyright (c) 2022 NetEase, Inc. All rights reserved.
# Use of this source code is governed by a MIT license that can be
# found in the LICENSE file.

Pod::Spec.new do |s|
  s.name             = 'NEVoiceRoomUIKit'
  s.version          = '1.0.0'
  s.summary          = 'A short description of NEVoiceRoomUIKit.'
  
  # This description is used to generate tags and improve search results.
  #   * Think: What does it do? Why did you write it? What is the focus?
  #   * Try to keep it short, snappy and to the point.
  #   * Write the description between the DESC delimiters below.
  #   * Finally, don't worry about the indent, CocoaPods strips it!
  
  s.description      = <<-DESC
  TODO: Add long description of the pod here.
  DESC
  
  s.homepage         = 'https://github.com/gingerjin1993@gmail.com/NEVoiceRoomUIKit'
  # s.screenshots     = 'www.example.com/screenshots_1', 'www.example.com/screenshots_2'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'gingerjin1993@gmail.com' => 'jinjie03@corp.netease.com' }
  s.source           = { :git => 'https://github.com/gingerjin1993@gmail.com/NEVoiceRoomUIKit.git', :tag => s.version.to_s }
  # s.social_media_url = 'https://twitter.com/<TWITTER_USERNAME>'
  
  s.ios.deployment_target = '9.0'
  
  s.source_files = 'NEVoiceRoomUIKit/Classes/**/*'
  
  s.dependency 'NEVoiceRoomKit'
  s.dependency 'NEOrderSong'
  s.dependency 'Masonry'
  s.dependency 'ReactiveObjC'
  s.dependency 'libextobjc'
  s.dependency 'YYModel'
  s.dependency 'MJRefresh'
  s.dependency 'M80AttributedLabel'
  s.dependency 'lottie-ios', '~> 2.5.3'
  s.dependency 'NEUIKit'
  s.dependency 'SDWebImage'
  s.dependency 'Toast'
  s.dependency 'NECopyrightedMedia'
  s.dependency 'NEAudioEffectKit'
  s.dependency 'NECoreKit'
  s.dependency 'LottieSwift'
  
  s.resource_bundles = {
    'NEVoiceRoomUIKit' => ['NEVoiceRoomUIKit/Assets/**/*']
  }
  s.frameworks = 'UIKit'
end