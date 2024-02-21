package com.example.pcspecsapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IPcSpecsService {
    @GET("pcSpecs")
    Call<List<PcSpecs>> getAllPcSpecs();
    @GET("pcSpecs/{id}")
    Call<PcSpecs> getPcSpecsById(@Path("id") int id);
    @POST("pcSpecs")
    Call<PcSpecs> addPcSpecs(@Body PcSpecs pcSpecs);
    @PUT("pcSpecs/{id}")
    Call<PcSpecs> updatePcSpecs(@Path("id") int id, @Body PcSpecs pcSpecs);
    @DELETE("pcSpecs/{id}")
    Call<PcSpecs> deletePcSpecs(@Path("id") int id);
}
