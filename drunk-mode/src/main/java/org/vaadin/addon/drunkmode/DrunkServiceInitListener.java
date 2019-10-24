package org.vaadin.addon.drunkmode;

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
        event.addDependencyFilter((dependencies, filterContext) -> {
            boolean isDrunk = UI.getCurrent().getRouter().getRegistry()
                    .getRegisteredRoutes().stream()
                    .map(RouteBaseData::getNavigationTarget)
                    .anyMatch(clazz -> clazz.isAnnotationPresent(DrunkMode.class));

            if (isDrunk) {
                dependencies.add(new Dependency(Dependency.Type.STYLESHEET,
                        "frontend://drunk-mode.css", LoadMode.EAGER));
                dependencies.add(
                        new Dependency(Dependency.Type.JAVASCRIPT,
                                "frontend://drunk-mode.js", LoadMode.EAGER));
            }

            return dependencies;
        });

    }

}