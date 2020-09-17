package com.idyndiouck.gads_leaderbord2020.api;

import androidx.annotation.NonNull;

import com.idyndiouck.gads_leaderbord2020.model.LearningLeader;
import com.idyndiouck.gads_leaderbord2020.model.SkillLeader;
import com.idyndiouck.gads_leaderbord2020.model.Submission;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

import static com.idyndiouck.gads_leaderbord2020.api.ApiConstants.GADS_BASEURL;

public class GadsApiService {

    private static RetrofitInterface retrofitInterface = new Retrofit.Builder()
            .baseUrl(GADS_BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RetrofitInterface.class);

    public static void getLearningLeaders(@NonNull final ApiResponseCallback<List<LearningLeader>> callback) {
        retrofitInterface.getLearningLeaders()
                .enqueue(new Callback<List<LearningLeader>>() {
                    @Override
                    public void onResponse(Call<List<LearningLeader>> call, Response<List<LearningLeader>> response) {
                        if (response.isSuccessful())
                            callback.onResponse(response.body());
                        else
                            callback.onError(new ApiResponseError(response));
                    }

                    @Override
                    public void onFailure(Call<List<LearningLeader>> call, Throwable t) {
                        callback.onError(t);
                    }
                });
    }

    public static void getSkillLeaders(@NonNull final ApiResponseCallback<List<SkillLeader>> callback) {
        retrofitInterface.getSkillLeaders()
                .enqueue(new Callback<List<SkillLeader>>() {
                    @Override
                    public void onResponse(Call<List<SkillLeader>> call, Response<List<SkillLeader>> response) {
                        if (response.isSuccessful())
                            callback.onResponse(response.body());
                        else
                            callback.onError(new ApiResponseError(response));
                    }

                    @Override
                    public void onFailure(Call<List<SkillLeader>> call, Throwable t) {
                        callback.onError(t);
                    }
                });
    }

    public static void submitProject(Submission submission, @NonNull final ApiResponseCallback<Void> callback) {
        retrofitInterface.submitProject(ApiConstants.GOOGLE_FORM_ENDPOINT, submission.getFirstName(), submission.getLastName(), submission.getEmail(), submission.getProjectUrl())
                .enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if (response.isSuccessful())
                            callback.onResponse(null);
                        else
                            callback.onError(new ApiResponseError(response));
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        callback.onError(t);
                    }
                });


    }

    interface RetrofitInterface {
        @GET("hours")
        Call<List<LearningLeader>> getLearningLeaders();

        @GET("skilliq")
        Call<List<SkillLeader>> getSkillLeaders();

        @FormUrlEncoded
        @POST
        Call<Void> submitProject(
                @Url String url,
                @Field("entry.1877115667") String firstName,
                @Field("entry.2006916086") String lastName,
                @Field("entry.1824927963") String email,
                @Field("entry.284483984") String projectUrl
        );

    }

}
