package com.baeldung.modules.main;

import com.baeldung.modules.hello.HelloModules;
import com.baeldung.modules.hello.HelloInterface;
import java.util.ServiceLoader;

public class MainApp {
    public static void main(String[] args) {
        // Llamada directa al método estático
        HelloModules.doSomething();

        // Opcional: Consumiendo el servicio mediante ServiceLoader
        Iterable<HelloInterface> services = ServiceLoader.load(HelloInterface.class);
        if (services.iterator().hasNext()) {
            HelloInterface service = services.iterator().next();
            service.sayHello();
        }
    }
}