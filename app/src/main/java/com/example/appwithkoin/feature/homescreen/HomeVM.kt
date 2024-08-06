import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appwithkoin.feature.homescreen.data.repository.ProductRepository
import kotlinx.coroutines.launch

class HomeVM(private val repository: ProductRepository) : ViewModel() {

    init {
        viewModelScope.launch {
            val res = repository.getHomeProduct()
                Log.d("MEssage",res.size.toString())
        }
    }
}
