package com.aquent.viewtools;

import org.osgi.framework.BundleContext;
import com.dotmarketing.osgi.GenericBundleActivator;

/**
 * SpamMeNot Viewtool Activator.
 * @author cfalzone
 */
public class SpamMeNotActivator extends GenericBundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {

        //Initializing services...
        initializeServices(bundleContext);

        //Registering the ViewTool service
        registerViewToolService(bundleContext, new SpamMeNotInfo());
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        unregisterViewToolServices();
    }

}
