/*
 * Copyright 2018 Nafundi
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ipa.collect.android.activities;

import android.os.Bundle;

import org.ipa.collect.android.spatial.MapHelper;

public abstract class BaseGeoMapActivity extends CollectAbstractActivity {
    private static final String MAP_LAYER_KEY = "map_layer_key";
    protected MapHelper helper;
    protected Bundle previousState;
    protected Integer selectedLayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        previousState = savedInstanceState;
        if (savedInstanceState != null) {
            selectedLayer = savedInstanceState.getInt(MAP_LAYER_KEY);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Initialization of helper is not guaranteed, as it is possible
        // for the activity to be stopped before initialization is complete.
        if (helper != null) {
            outState.putInt(MAP_LAYER_KEY, helper.getSelectedLayer());
        }
    }
}
