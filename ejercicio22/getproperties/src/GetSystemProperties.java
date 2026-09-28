/* 
Tecnológico Nacional de México
Instituto Tecnológico de León, Campus 1
Carrera: Ingeniería en Sistemas Computacionales
Materia: Topicos Avanzados de Programacion
Horario:
    Martes y Jueves de 7:00 a 8:45
    Viernes de 7:50 a 8:40
Alumno: Marlene Inés Moreno Velázquez
Ejercicio #22
Fecha: 01/09/2026 
*/

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Map;
import java.util.Set;

public class GetSystemProperties {
    public static void main(String[] args) {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();

        Map<String, String> systemProperties = runtimeBean.getSystemProperties();
        Set<String> keys = systemProperties.keySet();
        for (String key : keys) {
            String value = systemProperties.get(key);
            System.out.printf("[%s] = %s.\n", key, value);
        }
    }
}