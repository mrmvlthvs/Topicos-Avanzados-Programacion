module hello.modules {
    exports com.baeldung.modules.hello;
    
    // Opcional: Declarar que este módulo provee una implementación del servicio
    provides com.baeldung.modules.hello.HelloInterface 
        with com.baeldung.modules.hello.HelloModules;
}