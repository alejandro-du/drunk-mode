# Drunk Mode for Vaadin

An add-on component for Vaadin that shows how to use the `VaadinServiceInitListener` class to process views at runtime and add behaviour or custom CSS stlyles and JavaScript logic to them when a Java annotation is present.

## Building the project

```
git clone https://github.com/alejandro-du/drunk-mode.git
cd drunk-mode
mvn install
```

## Running the demo application

```
cd drunk-mode-demo
mvn jetty:run
```

## Useful links

* [Online demo](https://alejandro.app.fi/drunk-mode-demo)

* [Tutorial on how to implement this kind of functionality](https://vaadin.com/blog/how-we-implemented-a-drunk-mode-for-vaadin-at-springone-platform-2019)

* [The add-on is published on the Vaadin Directory (available as a Maven dependency)]( https://vaadin.com/directory/component/drunk-mode)

## Acknowledgements

Thanks to Markus Helberg for implementing the CSS animations and JavaScript logic.
