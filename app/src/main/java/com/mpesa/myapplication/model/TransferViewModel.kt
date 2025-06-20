//
//import android.app.Application
//import androidx.lifecycle.AndroidViewModel
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import androidx.room.Room
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.*
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//@HiltViewModel
//class TransferViewModel @Inject constructor(
//    private val transferDao: TransferDao  // Injected directly
//) : ViewModel() {  // Changed from AndroidViewModel to ViewModel
//
//    val transfers: StateFlow<List<Transfer>> = transferDao.getAllTransfers()
//        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
//
//    fun insertDummyTransfers() {
//        viewModelScope.launch {
//            transferDao.insertTransfer(
//                Transfer(
//                    bankName = "Commercial Bank",
//                    accountNumber = "100012345678",
//                    amount = 200
//                )
//            )
//        }
//    }
//
//    fun insertTransfer(transfer: Transfer) {
//        viewModelScope.launch {
//            transferDao.insertTransfer(transfer)
//        }
//    }
//}