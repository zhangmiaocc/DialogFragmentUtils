package com.zm.dialogfragmentutils;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dialog = ConnectionDialog.RecommendDialog(MainActivity.this, new ConnectionIViewCallBack() {
                        @Override
                        public void OnCancelCallback() {
                            dialog.dismiss();
                            Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void OnSureCallback() {
                            Toast.makeText(MainActivity.this, "确定", Toast.LENGTH_LONG).show();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (dialog != null) {
                    dialog.dismiss();
                }
                if (dialog != null) {
                    dialog.show();
                }
            }
        });
    }
}
