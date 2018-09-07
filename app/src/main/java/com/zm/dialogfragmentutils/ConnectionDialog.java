package com.zm.dialogfragmentutils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class ConnectionDialog {
    public static Dialog RecommendDialog(final Context context, ConnectionIViewCallBack _callback) throws Exception {

        if (context == null)
            return null;

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.dialogview, null);// 得到加载view
        TextView tv_sure_btn = (TextView) v.findViewById(R.id.tv_sure_btn);
        TextView tv_cancle_btn = (TextView) v.findViewById(R.id.tv_cancle_btn);

        final Dialog zsc_mainDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        final ConnectionIViewCallBack ZSC_callback = _callback;

        // 取消
        tv_cancle_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                zsc_mainDialog.dismiss();
                ZSC_callback.OnCancelCallback();

            }
        });

        // 确定
        tv_sure_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (zsc_mainDialog == null) {
                    return;
                }
                zsc_mainDialog.dismiss();
                ZSC_callback.OnSureCallback();

            }
        });

        zsc_mainDialog.setCancelable(true);// 设置可以用“返回键”取消
        zsc_mainDialog.setCanceledOnTouchOutside(false);// 设置点击其他区域不可取消
        zsc_mainDialog.setContentView(v);

        return zsc_mainDialog;
    }

}
