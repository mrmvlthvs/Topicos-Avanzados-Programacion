#include <QApplication>
#include <QWidget>
#include <QLabel>
#include <QVBoxLayout>
#include <iostream>
#include <string>

using namespace std;

class InterfazQt {
private:
    int argc;
    char** argv;
    string mensaje;
    QWidget* ventana;

public:
    InterfazQt(int argc, char** argv) {
        this->argc = argc;
        this->argv = argv;
        this->ventana = nullptr;
    }

    // 1. META
    void meta() {
        cout << "=== EJERCICIO 8 BIS: GUI CON C++ (Qt) ===" << endl;
        cout << "Programa para desplegar una interfaz grafica usando la" << endl;
        cout << "biblioteca Qt, estructurado en las 5 fases." << endl;
    }

    // 2. DATA
    void data() {
        cout << "Ingrese el mensaje a mostrar en la ventana Qt: ";
        getline(cin, mensaje);
        if (mensaje.empty()) mensaje = "¡Hola Qt desde el ITL!";
    }

    // 3. PROCESO
    void proceso(QApplication& app) {
        ventana = new QWidget();
        ventana->setWindowTitle("Ejercicio 8 Bis - Marlene");
        ventana->resize(350, 150);

        QVBoxLayout* layout = new QVBoxLayout(ventana);
        QLabel* etiqueta = new QLabel(QString::fromStdString(mensaje));
        etiqueta->setAlignment(Qt::AlignCenter);

        layout->addWidget(etiqueta);
    }

    // 4. RESULTADOS
    void resultados(QApplication& app) {
        if (ventana != nullptr) {
            ventana->show();
            cout << "-> Interfaz grafica desplegada en pantalla." << endl;

            // exec() transfiere el control al Event Loop de Qt
            app.exec();

            delete ventana;
            ventana = nullptr;
        }
    }

    // 5. NAVEGABILIDAD
    void navegabilidad() {
        QApplication app(argc, argv);
        string opcion;

        while (true) {
            cout << "\n1. Desplegar GUI Qt\n2. Salir\nOpcion: ";
            getline(cin, opcion);

            if (opcion == "1") {
                data();
                proceso(app);
                resultados(app);
            }
            else if (opcion == "2") {
                cout << "Finalizando programa ordenadamente..." << endl;
                break;
            }
            else {
                cout << "Opcion invalida. Intente de nuevo." << endl;
            }
        }
    }
};

int main(int argc, char* argv[]) {
    InterfazQt appQt(argc, argv);
    appQt.meta();
    appQt.navegabilidad();
    return 0;
}