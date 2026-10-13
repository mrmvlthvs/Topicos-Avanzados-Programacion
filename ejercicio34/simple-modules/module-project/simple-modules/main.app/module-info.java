module main.app {
    requires hello.modules;
    
    // Opcional: Indicar que este módulo consume el servicio
    uses com.baeldung.modules.hello.HelloInterface;
}