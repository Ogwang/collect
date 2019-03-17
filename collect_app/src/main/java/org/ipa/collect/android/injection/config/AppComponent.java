package org.ipa.collect.android.injection.config;

import android.app.Application;

import org.ipa.collect.android.activities.FormDownloadList;
import org.ipa.collect.android.activities.FormEntryActivity;
import org.ipa.collect.android.activities.InstanceUploaderList;
import org.ipa.collect.android.adapters.InstanceUploaderAdapter;
import org.ipa.collect.android.application.Collect;
import org.ipa.collect.android.fragments.DataManagerList;
import org.ipa.collect.android.http.CollectServerClient;
import org.ipa.collect.android.injection.ActivityBuilder;
import org.ipa.collect.android.injection.config.scopes.PerApplication;
import org.ipa.collect.android.logic.PropertyManager;
import org.ipa.collect.android.preferences.ServerPreferencesFragment;
import org.ipa.collect.android.tasks.InstanceServerUploaderTask;
import org.ipa.collect.android.tasks.sms.SmsSentBroadcastReceiver;
import org.ipa.collect.android.tasks.sms.SmsNotificationReceiver;
import org.ipa.collect.android.tasks.sms.SmsSender;
import org.ipa.collect.android.tasks.sms.SmsService;
import org.ipa.collect.android.utilities.AuthDialogUtility;
import org.ipa.collect.android.utilities.DownloadFormListUtils;
import org.ipa.collect.android.utilities.FormDownloader;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Primary module, bootstraps the injection system and
 * injects the main Collect instance here.
 * <p>
 * Shouldn't be modified unless absolutely necessary.
 */
@PerApplication
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class
})
public interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }

    void inject(Collect collect);

    void inject(SmsService smsService);

    void inject(SmsSender smsSender);

    void inject(SmsSentBroadcastReceiver smsSentBroadcastReceiver);

    void inject(SmsNotificationReceiver smsNotificationReceiver);

    void inject(InstanceUploaderList instanceUploaderList);

    void inject(InstanceUploaderAdapter instanceUploaderAdapter);

    void inject(DataManagerList dataManagerList);

    void inject(PropertyManager propertyManager);

    void inject(FormEntryActivity formEntryActivity);

    void inject(InstanceServerUploaderTask uploader);

    void inject(CollectServerClient collectClient);

    void inject(ServerPreferencesFragment serverPreferencesFragment);

    void inject(FormDownloader formDownloader);

    void inject(DownloadFormListUtils downloadFormListUtils);

    void inject(AuthDialogUtility authDialogUtility);
  
    void inject(FormDownloadList formDownloadList);
}
