/*
 * WiFi Analyzer
 * Copyright (C) 2016  VREM Software Development <VREMSoftwareDevelopment@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.vrem.wifianalyzer.wifi;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;

import com.vrem.wifianalyzer.MainContext;
import com.vrem.wifianalyzer.R;
import com.vrem.wifianalyzer.wifi.model.WiFiDetail;

public class AccessPointPopup {

    public Dialog show(@NonNull View view) {
        Dialog dialog = new Dialog(MainContext.INSTANCE.getMainActivity());
        dialog.setContentView(view);
        dialog.findViewById(R.id.popupButtonClose).setOnClickListener(new PopupDialogCloseListener(dialog));
        dialog.show();
        return dialog;
    }

    void attach(@NonNull View view, @NonNull WiFiDetail wiFiDetail) {
        view.setOnClickListener(new PopupDialogOpenListener(wiFiDetail));
    }

    private class PopupDialogCloseListener implements OnClickListener {
        private final Dialog dialog;

        PopupDialogCloseListener(@NonNull Dialog dialog) {
            this.dialog = dialog;
        }

        @Override
        public void onClick(View view) {
            dialog.dismiss();
        }
    }

    private class PopupDialogOpenListener implements OnClickListener {
        private final WiFiDetail wiFiDetail;

        PopupDialogOpenListener(@NonNull WiFiDetail wiFiDetail) {
            this.wiFiDetail = wiFiDetail;
        }

        @Override
        public void onClick(View view) {
            show(new AccessPointDetail().makeViewPopup(wiFiDetail));
        }
    }

}
