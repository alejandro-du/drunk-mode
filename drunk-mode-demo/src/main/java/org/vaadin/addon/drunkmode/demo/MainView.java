package org.vaadin.addon.drunkmode.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.vaadin.addon.drunkmode.DrunkMode;

@PWA(name = "Nuclear Reactor Control", shortName = "Nuclear Reactor Control")
@DrunkMode
@Route
public class MainView extends VerticalLayout {

    public MainView() {
        ProgressBar progressBar = new ProgressBar();
        progressBar.setIndeterminate(true);

        Button increaseRadiation = new Button("Increase radiation", VaadinIcon.ARROW_UP.create(), e -> Notification.show("Fingers crossed.", 5000, Notification.Position.MIDDLE));
        increaseRadiation.addThemeVariants(ButtonVariant.LUMO_ERROR);

        Button shutdownCooling = new Button("Shutdown cooling", VaadinIcon.POWER_OFF.create(), e -> Notification.show("Cheers.", 5000, Notification.Position.MIDDLE));
        shutdownCooling.addThemeVariants(ButtonVariant.LUMO_SUCCESS);

        NumberField temperature = new NumberField("Temperature");
        temperature.setHasControls(true);

        NumberField pressure = new NumberField("Pressure");
        pressure.setHasControls(true);

        NumberField hydrogen = new NumberField("Hydrogen");
        hydrogen.setHasControls(true);

        NumberField oxygen = new NumberField("Oxygen");
        oxygen.setHasControls(true);

        DatePicker shutdownDate = new DatePicker("Shutdown date");

        Button updateReactor = new Button("Update reactor", VaadinIcon.WARNING.create(), e -> Notification.show("Reactor updated. We all hope you are sober.", 5000, Notification.Position.MIDDLE));
        updateReactor.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        updateReactor.setWidth("100%");

        VerticalLayout form = new VerticalLayout(
                progressBar,
                new FormLayout(
                        increaseRadiation,
                        shutdownCooling,
                        temperature,
                        pressure,
                        hydrogen,
                        oxygen,
                        shutdownDate
                ),
                updateReactor,
                new Anchor("https://vaadin.com/blog/how-we-implemented-a-drunk-mode-for-vaadin-at-springone-platform-2019", "Learn more about the @DrunkMode annotation.")
        );

        add(
                new H1("Nuclear Reactor Control"),
                form
        );

        setAlignItems(Alignment.CENTER);
    }

}
