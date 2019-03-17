package org.ipa.collect.android.widgets;

import android.support.annotation.NonNull;

import org.ipa.collect.android.widgets.base.GeneralSelectOneWidgetTest;
import org.robolectric.RuntimeEnvironment;

/**
 * @author James Knight
 */

public class GridWidgetTest extends GeneralSelectOneWidgetTest<GridWidget> {
    @NonNull
    @Override
    public GridWidget createWidget() {
        return new GridWidget(RuntimeEnvironment.application, formEntryPrompt, 1, false);
    }
}
