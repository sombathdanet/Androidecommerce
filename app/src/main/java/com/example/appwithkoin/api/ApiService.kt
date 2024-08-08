import com.example.appwithkoin.feature.homescreen.data.model.response.CategoryResponse
import com.example.appwithkoin.feature.homescreen.data.model.response.ProductHome
import retrofit2.Response
import retrofit2.http.GET

class  ENDPOINT{
    companion object{
        const val  CAT_G = "get-product-category.php"
        const val ALL_PRODUCT = "get-product-home.php"
        const val GET_ONE_PRODUCT = "get-product-category.php"
    }
}
interface ApiService{
    @GET(value = ENDPOINT.CAT_G)
    suspend fun getCategories(): Response<CategoryResponse>
    @GET(value = ENDPOINT.ALL_PRODUCT)
    suspend fun getHomeProduct(): Response<ProductHome>
}