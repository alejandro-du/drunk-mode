package org.vaadin.drunkmode;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.RouteBaseData;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.shared.ui.Dependency;
import com.vaadin.flow.shared.ui.LoadMode;

public class DrunkServiceInitListener
        implements VaadinServiceInitListener {

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.addBootstrapListener(response -> {
            // BoostrapListener to change the bootstrap page
        });

        event.addDependencyFilter((dependencies, filterContext) -> {
            // DependencyFilter to add/remove/change dependencies sent to
            // the client
            boolean isDrunk = UI.getCurrent().getRouter().getRegistry().getRegisteredRoutes().stream()
                    .map(RouteBaseData::getNavigationTarget)
                    .anyMatch(clazz -> clazz.isAnnotationPresent(DrunkMode.class));

            if (isDrunk) {
                dependencies.add(new Dependency(Dependency.Type.STYLESHEET, "frontend://drunk-mode.css", LoadMode.EAGER));
                dependencies.add(new Dependency(Dependency.Type.JAVASCRIPT, "frontend://drunk-mode.js", LoadMode.EAGER));
            }

            return dependencies;
        });

        event.addRequestHandler((session, request, response) -> {
            // RequestHandler to change how responses are handled
            return false;
        });
    }

}