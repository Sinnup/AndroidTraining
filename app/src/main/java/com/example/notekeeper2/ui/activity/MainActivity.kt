package com.example.notekeeper2.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.notekeeper2.CourseInfo
import com.example.notekeeper2.DataManager
import com.example.notekeeper2.Model.MainActivityObserver
import com.example.notekeeper2.Model.MainActivityViewModel
import com.example.notekeeper2.R
import com.example.notekeeper2.Services.FakeUserResponse
import com.example.notekeeper2.Services.FakeUserService

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

   // val BASE_URL = "https://api.github.com/search/"

    private val TAG: String = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        Log.i(TAG, "Owner ON_CREATE")
        lifecycle.addObserver(MainActivityObserver())

        val dm = DataManager()
        val adapterCourses = ArrayAdapter<CourseInfo>(this,
            R.layout.simple_spinner_item_custom,
            dm.courses.values.toList())
        adapterCourses.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)
        spinnerCourses.adapter = adapterCourses

        val model = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        val myResponse : LiveData<String> = model.getDataLoaded()

        myResponse.observe(this, Observer<String> {text ->
            textDisplayedValue.setText(text)

        })



        fab.setOnClickListener { view ->

            /*
            val originalValue = textDisplayedValue.text.toString().toInt()
            val newValue = originalValue * 2
            textDisplayedValue.text = newValue.toString()
            Snackbar.make(view, "Value $originalValue changed to $newValue",
                Snackbar.LENGTH_LONG)
                .show()
            */

            //val myData = MainActivityDataStorage()


            val queue = Volley.newRequestQueue(this)
            val url = "https://api.github.com/search/users?q=eyehunt"
            val stringRequest = object : StringRequest(Method.GET, url,
                Response.Listener<String> { response ->
                    Log.i("Response", "The response is: $response")
                    model.insertDataLoaded(response)
                    //myResponse = model.getDataLoaded(response)
                    //textDisplayedValue.setText(myResponse)
                },
                Response.ErrorListener { error ->
                    Log.e("Error", "There was an error $error")
                }) {
                @Throws(AuthFailureError::class)
                override fun getHeaders(): Map<String, String> {
                    val headers = HashMap<String, String>()
                    headers.put("Content-Type", "application/json")
                    return headers
                }
            }
            queue.add(stringRequest)



            getWeatherNow()



            
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }


    fun getWeatherNow() {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(FakeUserService::class.java)
        val call = service.getUser(USER_ID)

        Log.i("URL", call.request().url().toString())
        call.enqueue(object : Callback<FakeUserResponse> {
            override fun onResponse(call: Call<FakeUserResponse>, response: retrofit2.Response<FakeUserResponse>) {

                if (response.code() == 200){

                    val fakeUserResponse = response.body()

                    Log.i("Response", fakeUserResponse.toString())

                }
            }

            override fun onFailure(call: Call<FakeUserResponse>, t: Throwable) {
                Log.i("Failure", t.message)
            }
        })
    }

    companion object {

        var BASE_URL = "https://jsonplaceholder.typicode.com/"
        var USER_ID = "2"
    }

}
