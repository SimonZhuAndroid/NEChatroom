// Copyright (c) 2022 NetEase, Inc. All rights reserved.
// Use of this source code is governed by a MIT license that can be
// found in the LICENSE file.

package com.netease.yunxin.kit.voiceroomkit.ui.dialog;

import android.app.Activity;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.SwitchCompat;
import com.netease.yunxin.kit.common.utils.DeviceUtils;
import com.netease.yunxin.kit.voiceroomkit.api.NEVoiceRoomKit;
import com.netease.yunxin.kit.voiceroomkit.ui.R;
import com.netease.yunxin.kit.voiceroomkit.ui.helper.EffectPlayHelper;
import com.netease.yunxin.kit.voiceroomkit.ui.widget.VolumeSetup;

/** Created by luc on 1/28/21. */
public class ChatRoomMixerDialog extends BottomBaseDialog {

  private final EffectPlayHelper effectPlayHelper;
  private int earBack = 100;
  private boolean isAnchor;

  public ChatRoomMixerDialog(
      @NonNull Activity activity, EffectPlayHelper effectPlayHelper, boolean isAnchor) {
    super(activity);
    this.effectPlayHelper = effectPlayHelper;
    this.isAnchor = isAnchor;
  }

  @Override
  protected void renderTopView(FrameLayout parent) {
    TextView titleView = new TextView(getContext());
    titleView.setText(getContext().getString(R.string.voiceroom_mixer));
    titleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
    titleView.setGravity(Gravity.CENTER);
    titleView.setTextColor(Color.parseColor("#ff333333"));
    FrameLayout.LayoutParams layoutParams =
        new FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    parent.addView(titleView, layoutParams);
  }

  @Override
  protected void renderBottomView(FrameLayout parent) {
    View bottomView =
        LayoutInflater.from(getContext()).inflate(R.layout.view_dialog_more_mixer, parent);

    SwitchCompat earBackSwitch = bottomView.findViewById(R.id.ear_back);
    earBackSwitch.setChecked(NEVoiceRoomKit.getInstance().isEarbackEnable());
    earBackSwitch.setOnCheckedChangeListener(
        (buttonView, isChecked) -> {
          if (!DeviceUtils.hasEarBack(getContext())) {
            buttonView.setChecked(false);
            return;
          }
          if (isChecked) {
            NEVoiceRoomKit.getInstance().enableEarback(earBack);
          } else {
            NEVoiceRoomKit.getInstance().disableEarback();
          }
        });

    SeekBar skRecordingVolume = bottomView.findViewById(R.id.recording_volume_control);
    skRecordingVolume.setProgress(effectPlayHelper.getAudioCaptureVolume());
    skRecordingVolume.setOnSeekBarChangeListener(
        new VolumeSetup() {
          @Override
          protected void onVolume(int volume) {
            effectPlayHelper.setAudioCaptureVolume(volume);
          }
        });
    TextView tvMixer = bottomView.findViewById(R.id.tv_mixer);
    SeekBar sbMixer = bottomView.findViewById(R.id.sb_mixer);
    if (isAnchor) {
      tvMixer.setVisibility(View.VISIBLE);
      sbMixer.setVisibility(View.VISIBLE);
      sbMixer.setProgress(effectPlayHelper.getAudioMixingVolume());
      sbMixer.setOnSeekBarChangeListener(
          new VolumeSetup() {
            @Override
            protected void onVolume(int volume) {
              effectPlayHelper.setAudioMixingVolume(volume);
            }
          });
    } else {
      tvMixer.setVisibility(View.GONE);
      sbMixer.setVisibility(View.GONE);
    }
  }
}