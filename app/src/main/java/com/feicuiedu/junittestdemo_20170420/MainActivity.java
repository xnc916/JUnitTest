package com.feicuiedu.junittestdemo_20170420;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.feicuiedu.junittestdemo_20170420.network.EasyShopClient;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etName)
    EditText mEtName;
    @BindView(R.id.etPassword)
    EditText mEtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnLogin)
    public void login() {

        EasyShopClient.getInstance().login(mEtName.getText().toString(), mEtPassword.getText().toString()).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

                Log.i("TAG","失败");

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                Log.i("TAG","成功");


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}
