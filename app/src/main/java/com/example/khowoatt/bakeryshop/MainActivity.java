package com.example.khowoatt.bakeryshop;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    private UserTable objUserTABLE;
    private BakeryTable objBakeryTABLE;
    private OrderTable objOrderTABLE;
    private CakeTable objCakeTABLE;
    private DrinkTable objDrinkTABLE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectedSQLite();
        testAddValue();
        synJSONtoSQLite();

    }

    private void synJSONtoSQLite() {
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        int intTimes = 0;
        while (intTimes <= 1)
        {
            InputStream objInputStream = null;
            String strJSON = null;
            String strUserURL = "http://5711020660011.sci.dusit.ac.th/user.php";
            String strBakeryURL = "http://5711020660011.sci.dusit.ac.th/bakery.php";
            String strCakeURL = "http://5711020660011.sci.dusit.ac.th/cake.php";
            String strDrinkURL = "http://5711020660011.sci.dusit.ac.th/drink.php";
            String strOrderURL = "http://5711020660011.sci.dusit.ac.th/order.php";
            HttpPost objHttpPost;

            try {
                HttpClient objHttpClient = new DefaultHttpClient();
                switch(intTimes){
                    case 0:
                        objHttpPost = new HttpPost(strUserURL) ;
                        break;
                    case 1:
                        objHttpPost = new HttpPost(strBakeryURL);
                        break;
                    case 2:
                        objHttpPost = new HttpPost(strCakeURL);
                        break;
                    case 3:
                        objHttpPost = new HttpPost(strDrinkURL);
                        break;
                    default:
                        objHttpPost = new HttpPost(strOrderURL);
                        break;

                }
                HttpResponse objHttpResponse = objHttpClient.execute(objHttpPost);
                HttpEntity objHttpEntity = objHttpResponse.getEntity();
                objInputStream = objHttpEntity.getContent();
            }catch (Exception e){
                Log.d("Eror","InputStream ==>"+ e.toString());
            }
            try{
                BufferedReader objBufferedReader = new BufferedReader
                        (new InputStreamReader(objInputStream,"UTF-8"));
                StringBuilder objStringBuilder = new StringBuilder();
                String strLine = null;
                while ((strLine = objBufferedReader.readLine())!= null)
                {
                    objStringBuilder.append(strLine);
                }
                objInputStream.close();
                strJSON = objStringBuilder.toString();
            } catch (Exception e){
                Log.d("Eror","strJSON ==>"+e.toString());
            }
            try {
                JSONArray objJsonArray = new JSONArray(strJSON);
                for (int i = 0; i < objJsonArray.length(); i++) {
                    JSONObject jsonObject = objJsonArray.getJSONObject(i);
                    switch (intTimes) {
                        case 0:
                            String strUsername = jsonObject.getString("Username");
                            String strPassword = jsonObject.getString("Password");
                            String strFacebook = jsonObject.getString("Facebook");
                            String strPhone = jsonObject.getString("Phone");
                            String strAddress = jsonObject.getString("Address");
                            String strEmail = jsonObject.getString("Email");
                            long addvalue = objUserTABLE.addNewUser(strUsername,strPassword,strFacebook,strPhone,strAddress,strEmail);

                            break;
                        case 1:
                            String strName_bakery = jsonObject.getString("NameBakery");
                            String strDetail_bakery = jsonObject.getString("DetailBakery");
                            String strPicture_bakery = jsonObject.getString("PictureBakery");
                            addvalue = objBakeryTABLE.addNewBakery(strName_bakery,strDetail_bakery,strPicture_bakery);

                            break;
                        case 2:
                            String strName_cake = jsonObject.getString("NameCake");
                            String strDetail_cake = jsonObject.getString("DetailCake");
                            String strPicture_cake = jsonObject.getString("PictureCake");
                            addvalue = objCakeTABLE.addNewCake(strName_cake,strDetail_cake,strPicture_cake);
                            break;
                        case 3:
                            String strName_drink = jsonObject.getString("NameDrink");
                            String strDetail_drink = jsonObject.getString("DetailDrink");
                            String strPicture_drink = jsonObject.getString("PictureDrink");
                            addvalue = objDrinkTABLE.addNewDrink(strName_drink,strDetail_drink,strPicture_drink);
                            break;
                        default:
                            String strprice = jsonObject.getString("Price");
                            String strNumber = jsonObject.getString("Number");
                            String strDate = jsonObject.getString("Date");
                            String strTotalPrice = jsonObject.getString("TotalPrice");
                            addvalue = objOrderTABLE.addNewOrder(strprice,strNumber,strDate,strTotalPrice);
                            break;
                    }
                }
            } catch (Exception e) {
                Log.d("Error","Update SQLite ==>" + e.toString());
            }
            intTimes +=1;
        }
    }

    public void onClickCake (View view){
        Intent intent = new Intent(MainActivity.this,CakeMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu Cake
    public void onClickBread (View view){
        Intent intent= new Intent(MainActivity.this,BreadMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu bread
    public void onClickDrinks (View view){
        Intent intent= new Intent(MainActivity.this,DrinkMenu.class);
        startActivity(intent);
    }//ลิ้งไปหน้า Menu Drink
    public void onClickLogin (View view){
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
    }//ลิ้งกลับหน้า login

    public void testAddValue(){
        objUserTABLE.addNewUser("testUser","testPass","testName","testEmail","testPhone","testAddress");
        objBakeryTABLE.addNewBakery("testBakery","testSource","testPrice");
        objOrderTABLE.addNewOrder("testOfficer","testBakery","testDate","testTotalPrice");
        objDrinkTABLE.addNewDrink("testDrink","testSource","testPrice");
        objCakeTABLE.addNewCake("testCake","testSource","testPrice");
    }

    private void connectedSQLite(){
        objUserTABLE = new UserTable(this);
        objBakeryTABLE = new BakeryTable(this);
        objOrderTABLE = new OrderTable(this);
        objCakeTABLE = new CakeTable(this);
        objDrinkTABLE = new DrinkTable(this);
    }



}
