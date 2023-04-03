// Copyright (c) 2022 NetEase, Inc. All rights reserved.
// Use of this source code is governed by a MIT license that can be
// found in the LICENSE file.

package com.netease.yunxin.app.chatroom.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.netease.yunxin.app.chatroom.R;
import com.netease.yunxin.app.chatroom.config.AppConfig;
import com.netease.yunxin.app.chatroom.roomlist.RoomListActivity;
import com.netease.yunxin.app.listentogether.Constants;
import com.netease.yunxin.kit.voiceroomkit.api.NELiveType;
import com.netease.yunxin.kit.voiceroomkit.ui.adapter.FunctionAdapter;
import com.netease.yunxin.kit.voiceroomkit.ui.fragment.BaseFragment;
import java.util.ArrayList;
import java.util.List;

public class AppEntranceFragment extends BaseFragment {

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_app_entrance, container, false);
    initView(rootView);
    paddingStatusBarHeight(rootView);
    return rootView;
  }

  private void initView(View rootView) {
    ImageView topLogoImageView = rootView.findViewById(R.id.iv_top_logo);
    topLogoImageView.setImageResource(R.drawable.icon_app_top_logo);
    RecyclerView rvFunctionList = rootView.findViewById(R.id.rv_function_list);
    rvFunctionList.setLayoutManager(
        new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
    List<FunctionAdapter.FunctionItem> list = new ArrayList<>();
    list.add(
        new FunctionAdapter.FunctionItem(
            R.drawable.video_call_icon,
            getString(R.string.app_voiceroom),
            getString(R.string.app_voiceroom_desc_text),
            () -> {
              Intent intent = new Intent(getActivity(), RoomListActivity.class);
              intent.putExtra(Constants.INTENT_LIVE_TYPE, NELiveType.LIVE_TYPE_VOICE);
              startActivity(intent);
            }));
    if (!AppConfig.isOversea()) {
      list.add(
          new FunctionAdapter.FunctionItem(
              R.drawable.icon_listen_together,
              getString(R.string.app_listen_together),
              getString(R.string.app_listen_together_desc_text),
              () -> {
                Intent intent = new Intent(getActivity(), RoomListActivity.class);
                intent.putExtra(Constants.INTENT_LIVE_TYPE, NELiveType.LIVE_TYPE_TOGETHER_LISTEN);
                startActivity(intent);
              }));
    }
    rvFunctionList.setAdapter(new FunctionAdapter(getContext(), list));
  }
}