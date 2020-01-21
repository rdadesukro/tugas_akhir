package com.example.tugas_akhir;




import com.example.tugas_akhir.model.Response_tugas;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface ApiRequest {







    @POST("tugas.php")
    Call<Response_tugas> tugas();
//
//    @FormUrlEncoded
//    @POST("token.php")
//    Call<ResponsModel> gettoken(@Field("token") String token);
//
//
//    @GET("idn@droid/masalah_list.php")
//    Call<ResponsModel> getBiodata();
//
////    @GET("latihan/view.php")
////    Call<anggota_value> gettask(@Query("kelas") String kelas); // view berdasarkan ID
//
////    @GET("read2.php")
////    Call<ResponsModel> getBiodata2(@Query("token") String token);
//
//    @FormUrlEncoded
//    @POST("update.php")
//    Call<ResponsModel> updateData(@Field("id") String id,
//                                  @Field("nama") String nama,
//                                  @Field("jabatan") String jabatan);
//
//    @FormUrlEncoded
//    @POST("delete.php")
//    Call<ResponsModel> deleteData(@Field("id") String id);
}


