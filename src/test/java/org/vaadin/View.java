package org.vaadin;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.vaadin.drunkmode.DrunkMode;

@Route("")
@DrunkMode
public class View extends Div {

    public View() {
        add(new TextField("Type some text to activate the drunk mode"));
    }

}
