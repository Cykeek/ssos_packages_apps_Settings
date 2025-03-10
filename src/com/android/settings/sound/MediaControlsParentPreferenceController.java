/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.settings.sound;

import android.content.Context;
import android.provider.Settings;

import com.android.settings.R;
import com.android.settings.core.BasePreferenceController;

/**
 * Parent menu summary of media controls settings
 */
public class MediaControlsParentPreferenceController extends BasePreferenceController {

    public MediaControlsParentPreferenceController(Context context, String key) {
        super(context, key);
    }

    @Override
    public int getAvailabilityStatus() {
        return AVAILABLE;
    }

    @Override
    public CharSequence getSummary() {
        int summary;
        if (Settings.System.getInt(mContext.getContentResolver(), Settings.System.QS_MEDIA_PLAYER, 1) == 0) {
            summary = R.string.qs_media_player_summary_off_controller;
        } else {
            summary = R.string.qs_media_player_summary_on_controller;
        }
        return mContext.getText(summary);
    }
}
