package com.github.xueqingxiao.shadowvpn;

import com.fizzbuzz.android.dagger.InjectingApplication;

import java.util.Collections;
import java.util.List;

import dagger.Module;
import timber.log.Timber;

/**
 * Created by qx90719 on 7/30/2015.
 */
@Module(
        library = true,
        injects = ShadowVPNApp.class,
        addsTo = InjectingApplication.InjectingApplicationModule.class,
        includes = {}
)
public class ShadowVPNApp extends InjectingApplication {

    static {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            // TODO: get error message when app has been released
//            Timber.plant(new ReleasedAppErrorTree());
//            Initialise Global RXJava error handler
//            RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandlerImpl());
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // TODO: send device info to GA
    }

    @Override
    protected List<Object> getModules() {
        List<Object> modules = super.getModules();
        Collections.addAll(modules, new ShadowVPNModule(this));
        return modules;
    }
}
