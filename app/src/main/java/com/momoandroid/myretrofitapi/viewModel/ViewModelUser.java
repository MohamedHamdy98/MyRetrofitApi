package com.momoandroid.myretrofitapi.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.momoandroid.myretrofitapi.data.UserClient;
import com.momoandroid.myretrofitapi.models.User;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class ViewModelUser extends ViewModel {
    private static final String TAG = "ViewModelUser";
    public MutableLiveData<List<User>> mutableLiveData = new MutableLiveData<>();
    CompositeDisposable disposable = new CompositeDisposable();
    public void getDataUser() {
        Single<List<User>> observal = UserClient.getInstance().getDataUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        disposable.add(observal.subscribe(i->mutableLiveData.setValue(i),e->Log.d(TAG,"Error:"+e)));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposable.clear();
    }
}
