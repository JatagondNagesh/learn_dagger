package com.mindorks.bootcamp.learndagger.ui;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mindorks.bootcamp.learndagger.MyApplication;
import com.mindorks.bootcamp.learndagger.R;
import com.mindorks.bootcamp.learndagger.di.component.DaggerActivityComponent;
import com.mindorks.bootcamp.learndagger.di.module.ActivityModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDependencies();
        setContentView(R.layout.activity_main);

        TextView tvData = findViewById(R.id.tvData);
        tvData.setText(viewModel.getSomeData());

        addHomeFragment();
    }

    private void addHomeFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, HomeFragment.newInstance(), HomeFragment.TAG)
                .commit();
    }

    public void getDependencies() {
        DaggerActivityComponent
                .builder()
                .applicationComponent(((MyApplication) getApplication()).applicationComponent)
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);

    }


/*    1. Create a class `NetworkHelper` in `utils`: package `com.mindorks.bootcamp.learndagger.utils`

    public class NetworkHelper {
        // Should be Application Context
        private Context context;

        public NetworkHelper(Context context) {
            this.context = context;
        }

        public boolean isNetworkConnected() {
// will check for network connectivity
            return false;
        }
    }

2. Create `HomeFragment` and `HomeViewModel`
    a. Make `NetworkHelper` as singleton instance
    b. Inject `DatabaseService`, `NetworkService`, and `NetworkHelper` in `HomeViewModel`
    c. Inject `HomeViewModel` in `HomeFragment`

            3. Add this `HomeFragment` to `MainActivity`

            4. Create all the classes for Dagger dependency injection for above classes*/
}
