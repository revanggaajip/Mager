package com.mager.gamer.data.remote



import com.mager.gamer.data.model.remote.komunitas.get.KomunitasResponse
import com.mager.gamer.data.model.remote.komunitas.join.JoinCommunityResponse
import com.mager.gamer.data.model.remote.login.LoginResponse
import com.mager.gamer.data.model.remote.password.ForgetPassBody
import com.mager.gamer.data.model.remote.password.ForgetPassResponse
import com.mager.gamer.data.model.remote.postingan.create.CreatePostinganResponse
import com.mager.gamer.data.model.remote.postingan.delete.DeleteResponse
import com.mager.gamer.data.model.remote.postingan.get.PostinganResponse
import com.mager.gamer.data.model.remote.postingan.komentar.KomentarBody
import com.mager.gamer.data.model.remote.postingan.komentar.KomentarPostinganResponse
import com.mager.gamer.data.model.remote.postingan.like.LikePostinganResponse
import com.mager.gamer.data.model.remote.postingan.post.CreatePostBody
import com.mager.gamer.data.model.remote.register.RegisterBody
import com.mager.gamer.data.model.remote.register.RegisterResponse
import com.mager.gamer.data.model.remote.upload.UploadResponse
import com.mager.gamer.data.model.remote.user.UserDetailResponse
import com.skydoves.sandwich.ApiResponse
import okhttp3.MultipartBody
import retrofit2.http.*

interface ApiService {

    @GET("mager/postingan")
    suspend fun getPostingan(
        @Query("size") size: Int,
        @Query("page") page: Int,
        @Query("sort") sort: String?,
        @Query("tipeSort") tipeSort: String?,
        @Query("tipeData") tipeData: String?,
        @Query("idKomunitas") idKomunitas: Int?,
    ) : ApiResponse<PostinganResponse>

    @POST("mager/postingan")
    suspend fun createPostingan(
        @Query("idUser") idUser: Int,
        @Body body: CreatePostBody
    ):ApiResponse<CreatePostinganResponse>

    @Multipart
    @POST("mager/uploadFiles")
    suspend fun uploadFiles(
        @Part file: MultipartBody.Part
    ): ApiResponse<UploadResponse>

    @POST("mager/like")
    suspend fun likePostingan(
        @Query("idPostingan") idPostingan: Int,
        @Query("idUser") idUser: Int,
    ): ApiResponse<LikePostinganResponse>

    @GET("mager/komunitas/list")
    suspend fun getKomunitas(
        @Query("size") size: Int,
        @Query("page") page: Int
    ) : ApiResponse<KomunitasResponse>

    @POST("mager/komunitas/join/{idUser}/{idCommunity}")
    suspend fun joinCommunity(
        @Path("idUser") idUser: Int,
        @Path("idCommunity") idCommunity: Int
    ): ApiResponse<JoinCommunityResponse>

    @FormUrlEncoded
    @POST("mager/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ) : ApiResponse<LoginResponse>

    @POST("mager/user")
    suspend fun register(
        @Body body: RegisterBody
    ):ApiResponse<RegisterResponse>

    @POST("mager/forget-password/register-tymeleaf")
    suspend fun forgetPass(
        @Body body: ForgetPassBody
    ):ApiResponse<ForgetPassResponse>

    @POST("mager/komentar")
    suspend fun komentar(
        @Query("idUser") idUser: Int,
        @Query("idPostingan") idPostingan: Int,
        @Body body : KomentarBody
    ):ApiResponse<KomentarPostinganResponse>

    @DELETE("mager/postingan")
    suspend fun deletePost(
        @Query("idPostingan") idPostingan: Int
    ):ApiResponse<DeleteResponse>

    @GET("mager/user/{idUser}")
    suspend fun userDetail(
        @Path("idUser") idUser: Int
    ):ApiResponse<UserDetailResponse>
}