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

        //testAddValue();

        synJSONtoSQLite();

    }

    private void synJSONtoSQLite() {
        StrictMode.ThreadPolicy myPolicy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(myPolicy);

        int intTimes = 0;
        while (intTimes <= 4)
        {
            InputStream objInputStream = null;
            String strJSON = null;
            String strUserURL = "http://bitmouse.96.lt/K/user.php";
            String strBakeryURL = "http://bitmouse.96.lt/K/bakery.php";
            String strCakeURL = "http://bitmouse.96.lt/K/cake.php";
            String strDrinkURL = "http://bitmouse.96.lt/K/drink.php";
            String strOrderURL = "http://bitmouse.96.lt/K/order.php";
            HttpPost objHttpPost = null;

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
                Log.d("Error","InputStream ==>"+ e.toString());
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
                Log.d("Error","strJSON ==>"+e.toString());
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
                            objUserTABLE.addNewUser(strUsername,strPassword,strFacebook,strPhone,strAddress,strEmail);

                            break;
                        case 1:
                            String strName_bakery = jsonObject.getString("Name_bakery");
                            String strDetail_bakery = jsonObject.getString("Detail_bakery");
                            String strPicture_bakery = jsonObject.getString("Picture_bakery");
                            objBakeryTABLE.addNewBakery(strName_bakery,strDetail_bakery,strPicture_bakery);

                            break;
                        case 2:
                            String strName_cake = jsonObject.getString("Name_cake");
                            String strDetail_cake = jsonObject.getString("Detail_cake");
                            String strPicture_cake = jsonObject.getString("Picture_cake");
                            objCakeTABLE.addNewCake(strName_cake,strDetail_cake,strPicture_cake);
                            break;
                        case 3:
                            String strName_drink = jsonObject.getString("Name_drink");
                            String strDetail_drink = jsonObject.getString("Detail_drink");
                            String strPicture_drink = jsonObject.getString("Picture_drink");
                            objDrinkTABLE.addNewDrink(strName_drink,strDetail_drink,strPicture_drink);
                            break;
                        default:
                            String strprice = jsonObject.getString("Price");
                            String strNumber = jsonObject.getString("Number");
                            String strDate = jsonObject.getString("Date");
                            String strTotalPrice = jsonObject.getString("TotalPrice");
                            objOrderTABLE.addNewOrder(strprice,strNumber,strDate,strTotalPrice);
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
