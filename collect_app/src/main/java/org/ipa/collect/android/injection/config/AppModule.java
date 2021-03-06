package org.ipa.collect.android.injection.config;

import android.app.Application;
import android.content.Context;
import android.telephony.SmsManager;

import org.ipa.collect.android.dao.FormsDao;
import org.ipa.collect.android.dao.InstancesDao;
import org.ipa.collect.android.events.RxEventBus;
import org.ipa.collect.android.http.CollectServerClient;
import org.ipa.collect.android.http.HttpClientConnection;
import org.ipa.collect.android.http.OpenRosaHttpInterface;
import org.ipa.collect.android.injection.ViewModelBuilder;
import org.ipa.collect.android.injection.config.architecture.ViewModelFactoryModule;
import org.ipa.collect.android.injection.config.scopes.PerApplication;
import org.ipa.collect.android.tasks.sms.SmsSubmissionManager;
import org.ipa.collect.android.tasks.sms.contracts.SmsSubmissionManagerContract;
import org.ipa.collect.android.utilities.WebCredentialsUtils;

import dagger.Module;
import dagger.Provides;

/**
 * Add Application level providers here, i.e. if you want to
 * inject something into the Collect instance.
 */
@Module(includes = {ViewModelFactoryModule.class, ViewModelBuilder.class})
public class AppModule {

    @Provides
    SmsManager provideSmsManager() {
        return SmsManager.getDefault();
    }

    @Provides
    SmsSubmissionManagerContract provideSmsSubmissionManager(Application application) {
        return new SmsSubmissionManager(application);
    }

    @Provides
    Context context(Application application) {
        return application;
    }

    @Provides
    InstancesDao provideInstancesDao() {
        return new InstancesDao();
    }

    @Provides
    FormsDao provideFormsDao() {
        return new FormsDao();
    }

    @PerApplication
    @Provides
    RxEventBus provideRxEventBus() {
        return new RxEventBus();
    }

    @Provides
    public OpenRosaHttpInterface provideHttpInterface() {
        return new HttpClientConnection();
    }

    @Provides
    public CollectServerClient provideCollectServerClient(OpenRosaHttpInterface httpInterface, WebCredentialsUtils webCredentialsUtils) {
        return new CollectServerClient(httpInterface, webCredentialsUtils);
    }

    @Provides
    public WebCredentialsUtils provideWebCredentials() {
        return new WebCredentialsUtils();
    }

}
