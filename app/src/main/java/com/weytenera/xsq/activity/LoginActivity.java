package com.weytenera.xsq.activity;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.weytenera.xsq.CustomRetrofit;
import com.weytenera.xsq.R;
import com.weytenera.xsq.base.BaseActivity;
import com.weytenera.xsq.interfaces.HomeInterface;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends BaseActivity {


    @Bind(R.id.login_user)
    EditText loginUser;
    @Bind(R.id.login_pass)
    EditText loginPass;
    @Bind(R.id.txt_forgot)
    TextView txtForgot;
    @Bind(R.id.btn_login)
    Button btnLogin;
    @Bind(R.id.btn_reg)
    Button btnReg;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    protected void init() {
        getSupportActionBar().setTitle("登录");

    }

    @Override
    protected void widgetListener() {

    }



    @OnClick({R.id.txt_forgot, R.id.btn_login, R.id.btn_reg})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.txt_forgot:

                break;
            case R.id.btn_login:
                login();
                break;
            case R.id.btn_reg:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
        }
    }


    public void login(){
        String user=loginUser.getText().toString().trim();
        String pass=loginPass.getText().toString().trim();

        if (TextUtils.isEmpty(user)) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
            return ;
        }
        if (TextUtils.isEmpty(pass)) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
            return ;
        }

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("UserCode", user);
        jsonObject.addProperty("Password", pass);

        Retrofit retrofit = CustomRetrofit.getRetrofit();

        retrofit.create(HomeInterface.class).login(jsonObject).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                JsonObject object = response.body();
                if(object!=null)
                 Log.e("ss",object.toString());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("ss","fail");
            }
        });


    }
}
