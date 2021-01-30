package com.example.assignment.service;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.assignment.network.APIClient;
import com.example.assignment.network.ResponseApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyWorker extends Worker {

    private static final String TAG = "My Worker";
    private static boolean isSuccess = false, finished = false;
    private static long timeElapsed = 0;

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        isSuccess = false;
        finished = false;
        timeElapsed = 0;
    }

    /**
     * Override this method to do your actual background processing.  This method is called on a
     * background thread - you are required to <b>synchronously</b> do your work and return the
     * {@link Result} from this method.  Once you return from this
     * method, the Worker is considered to have finished what its doing and will be destroyed.  If
     * you need to do your work asynchronously on a thread of your own choice, see
     * {@link ListenableWorker}.
     * <p>
     * A Worker is given a maximum of ten minutes to finish its execution and return a
     * {@link Result}.  After this time has expired, the Worker will
     * be signalled to stop.
     *
     * @return The {@link Result} of the computation; note that
     * dependent work will not execute if you use
     * {@link Result#failure()} or
     * {@link Result#failure(Data)}
     */
    @NonNull
    @Override
    public Result doWork() {
        Log.d(TAG, "Worker Running");
        ResponseApi responseApi = APIClient.getRetrofitClient().create(ResponseApi.class);
        Call<ResponseBody> call = responseApi.getAttribute(66159);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                int statusCode = response.code();
                Log.d(TAG, "response code from api is " + statusCode);
                try {
                    String responseInString = response.body().string();
                    Log.d(TAG, "response - " + responseInString);
                    JSONObject jsonObject = new JSONObject(responseInString);
                    JSONObject platforms = (JSONObject) jsonObject.getJSONArray("platforms").get(0);
                    JSONObject platformDefinition = platforms.getJSONObject("platformDefinition");
                    JSONObject attributeDefinitions = (JSONObject) platformDefinition.getJSONArray("attributeDefinitions").get(2);
                    Log.d(TAG, "version - " + attributeDefinitions.getString("order"));
                    isSuccess = true;
                    finished = true;
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    isSuccess = false;
                    finished = true;
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(TAG, "Failed to retrieve data");
                Log.d(TAG, t.toString());
                isSuccess = false;
                finished = true;
            }
        });
        while (!finished && timeElapsed <= 500) {
            try {
                timeElapsed += 100;
                Thread.sleep(timeElapsed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return isSuccess ? Result.success() : Result.failure();
    }
}