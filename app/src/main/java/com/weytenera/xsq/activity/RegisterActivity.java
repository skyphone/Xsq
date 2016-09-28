package com.weytenera.xsq.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.JsonObject;
import com.weytenera.xsq.CustomRetrofit;
import com.weytenera.xsq.R;
import com.weytenera.xsq.base.BaseActivity;
import com.weytenera.xsq.interfaces.HomeInterface;
import com.weytenera.xsq.views.CodeUtils;

import butterknife.Bind;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * <br/> Description: 注册
 * <br/> Author:  chencaisheng
 * <br/> Version: 1.0
 * <br/> Date:  2016/9/27 0027 上午 11:38
 */
public class RegisterActivity extends BaseActivity {


    @Bind(R.id.registered_phone)
    EditText registeredPhone;
    @Bind(R.id.registered_psw)
    EditText registeredPsw;
    @Bind(R.id.et_pwd_sure)
    EditText etPwdSure;
    @Bind(R.id.registered_yanz)
    EditText registeredYanz;
    @Bind(R.id.regist_code)
    TextView registCode;
    @Bind(R.id.edt_piccode)
    EditText edtPiccode;
    @Bind(R.id.img_code)
    ImageView imgCode;
    @Bind(R.id.btn_register)
    Button btnRegister;
    @Bind(R.id.btn_cancal)
    Button btnCancal;

    @Override
    protected int getContentViewId() {
        return R.layout.activity_register;
    }

    @Override
    protected void init() {
        getSupportActionBar().setTitle("注册");
        imgCode.setImageBitmap(CodeUtils.getInstance().createBitmap());


    }

    @Override
    protected void widgetListener() {

    }



    @OnClick({R.id.regist_code, R.id.img_code, R.id.btn_register, R.id.btn_cancal})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.regist_code:

                break;
            case R.id.img_code:
                imgCode.setImageBitmap(CodeUtils.getInstance().createBitmap());
                break;
            case R.id.btn_register:
                  regis();
                break;
            case R.id.btn_cancal:
                finish();
                break;
        }
    }




    public void regis(){
        String phone = registeredPhone.getText().toString().trim();
        String psw = registeredPsw.getText().toString().trim();
        String psw2 = etPwdSure.getText().toString().trim();
        String yanzhen = registeredYanz.getText().toString().trim();
        String picCode = edtPiccode.getText().toString().trim();


//        if (!NetUtils.isNetworkAvailable(this)) {
//            Toast.makeText(RegisteredActivity.this, "请检查网络", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        if (TextUtils.isEmpty(phone)) {
//            Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if(!RegUtils.isMobileNumber(phone)){
//            Toast.makeText(this, "手机号不正确", Toast.LENGTH_SHORT).show();
//            return;
//        }
//
//        if (TextUtils.isEmpty(psw)) {
//            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
//            return  ;
//        }
//        if (TextUtils.isEmpty(psw2)) {
//            Toast.makeText(this, "请输入重复密码", Toast.LENGTH_SHORT).show();
//            return ;
//        }
//
//        if (!psw2.equals(psw)) {
//            Toast.makeText(this, "密码不一致", Toast.LENGTH_SHORT).show();
//            return  ;
//        }
//
//        if (TextUtils.isEmpty(yanzhen)) {
//            Toast.makeText(this, "请输入短信验证码", Toast.LENGTH_SHORT).show();
//            return ;
//        }
//        if (TextUtils.isEmpty(picCode)) {
//            Toast.makeText(this, "请输入图形验证码", Toast.LENGTH_SHORT).show();
//            return ;
//        }
//
//        if(!picCode.equalsIgnoreCase(CodeUtils.getInstance().code)){
//            Toast.makeText(this, "请输入正确的图形验证码", Toast.LENGTH_SHORT).show();
//            return ;
//        }


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("mobile", phone);
        jsonObject.addProperty("pwd", psw);
        jsonObject.addProperty("validCode", "");

        Retrofit retrofit = CustomRetrofit.getRetrofit();

        retrofit.create(HomeInterface.class).register(jsonObject).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject object=response.body();
                if(object!=null)
                Log.e("ss", object.toString());
//                LogUtils.d(object);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("ss","fail");
            }
        });



    }
}
