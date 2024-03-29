package com.example.connect_odoo_mobile.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;

import com.example.connect_odoo_mobile.R;
import com.example.connect_odoo_mobile.handle.CheckPermission;

public class ChoosePictureDialog {
    private final Context context;
    private final CheckPermission checkPermission;

    public ChoosePictureDialog(Context context, CheckPermission checkPermission) {
        this.context = context;
        this.checkPermission = checkPermission;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void openDialog() {
        Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_choose_picture);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }

        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.BOTTOM;
        window.setAttributes(windowAttributes);
        //event close dialog when tap out dialog
        dialog.setCancelable(true);
        //mapping
        TextView txtCancel = dialog.findViewById(R.id.txtCancel);
        TextView txtLibrary = dialog.findViewById(R.id.txtLibrary);
        TextView txtCamera = dialog.findViewById(R.id.txtCamera);
        //event close dialog when tap cancel
        txtCancel.setOnClickListener(view -> dialog.cancel());
        //event choose picture from the library
        txtLibrary.setOnClickListener(view -> {
            dialog.cancel();
            checkPermission.checkPermission();
        });
        txtCamera.setOnClickListener(view -> {
            Toast.makeText(context, "Evolving functionality!", Toast.LENGTH_SHORT).show();
        });
        //show dialog
        dialog.show();
    }

}
