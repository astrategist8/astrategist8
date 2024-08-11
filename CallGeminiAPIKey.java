import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeminiAPI {

    private static final String BASE_URL = "https://generativelanguage.googleapis.com/v1beta/";
    private static final String API_KEY = "173642135169"; // Ganti dengan API key Anda

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static void generateContent(String prompt) {
        GeminiService service = retrofit.create(GeminiService.class);

        Call<GeminiResponse> call = service.generateContent(API_KEY, prompt);

        call.enqueue(new Callback<GeminiResponse>() {
            @Override
            public void onResponse(Call<GeminiResponse> call, Response<GeminiResponse> response) {
                if (response.isSuccessful()) {
                    GeminiResponse responseBody = response.body();
                    // Proses respons dari Gemini API
                    System.out.println(responseBody.getContents());
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<GeminiResponse> call, Throwable t) {
                // Handle error
            }
        });
    }

    // Interface untuk Gemini API
    public interface GeminiService {
        @POST("models/gemini-1.5-flash-latest:generateContent")
        Call<GeminiResponse> generateContent(
                @Query("key") String apiKey,
                @Body GeminiRequest request
        );
    }

    // Data kelas untuk permintaan Gemini API
    public static class GeminiRequest {
        public List<ContentPart> contents;

        public GeminiRequest(List<ContentPart> contents) {
            this.contents = contents;
        }
    }

    // Data kelas untuk bagian konten permintaan
    public static class ContentPart {
        public List<ContentPartText> parts;

        public ContentPart(List<ContentPartText> parts) {
            this.parts = parts;
        }
    }

    // Data kelas untuk teks bagian konten
    public static class ContentPartText {
        public String text;

        public ContentPartText(String text) {
            this.text = text;
        }
    }

    // Data kelas untuk respons Gemini API
    public static class GeminiResponse {
        public List<ContentPart> contents;

        public List<ContentPart> getContents() {
            return contents;
        }
    }
}
