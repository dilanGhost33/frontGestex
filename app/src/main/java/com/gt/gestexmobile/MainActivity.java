package com.gt.gestexmobile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.gt.gestexmobile.model.User;
import com.gt.gestexmobile.security.ApiUser;

import java.io.IOException;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public TextView YT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        YT = (TextView) findViewById(R.id.tv_status);
        String  url = "http://10.0.2.2:8080/gestex/api/rest/v1/";
        Button btn_login = (Button) findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            EditText etdni = (EditText) findViewById(R.id.et_name);
            EditText etpasword = (EditText) findViewById(R.id.et_password);

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            @Override
            public void onClick(View view) {
                String dni = etdni.getText().toString();
                String password = etpasword.getText().toString();
                logging.setLevel(HttpLoggingInterceptor.Level.BODY);
                OkHttpClient.Builder httpClient=new OkHttpClient.Builder();
                httpClient.addInterceptor(logging);

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(url)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client((httpClient).build())
                        .build();
                ApiUser login = retrofit.create(ApiUser.class);
                Call<User> call = login.LOGIN_CALL(dni,password);
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if (response.isSuccessful() ) {
                            etdni.getText().clear();
                            etpasword.getText().clear();
                            String tokenInter=response.headers().get("Authorization");
                            String rol=response.body().getRole().toString();

                            Intent intent = new Intent(MainActivity.this,loggeado.class);
                            intent.putExtra("token",tokenInter);
                            startActivity(intent);

                            Toast.makeText(MainActivity.this,"Welcome "+rol, Toast.LENGTH_LONG).show();

                        } else{
                            Toast.makeText(MainActivity.this,"Error en las credenciales", Toast.LENGTH_SHORT).show();
                            YT.setText("a "+response.code()+" "+response.errorBody());
                        }
                    }
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MainActivity.this,"Error fatal"+t.toString(), Toast.LENGTH_SHORT).show();
                        YT.setText(""+t.toString());
                        System.out.println(""+t.toString());

                    }
                });
            }
        });
    }
}