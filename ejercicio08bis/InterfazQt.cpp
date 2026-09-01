/*
 * =====================================================================
 * C++ con Qt: Implementacion de GUI integrando las 5 fases.
 * =====================================================================
 */
#include <QApplication>
#include <QWidget>
#include <QPushButton>
#include <QLabel>
hwkh#include <QLineEdit>
#include <QVBoxLayout>
#include <iostream>

class InterfazQt : public QWidget {
private:
    // 2. DATA: Declaracion de contenedores y activadores
    QVBoxLayout *panel;
    QLabel *lblMsg;
    QLineEdit *txtEntrada;
    QPushButton *btnOk;

public:
    InterfazQt(QWidget *parent = nullptr) : QWidget(parent) {
        data();
        proceso();
    }

    // 1. META: Objetivo del sistema
    void meta() {
        std::cout << "========= GUI EN C++ CON QT =========" << std::endl;
        std::cout << "Programa de interfaz grafica en C++ " << std::endl;
        std::cout << "aplicando las 5 fases del sistema." << std::endl;
        std::cout << "=====================================" << std::endl;
    }

    // 2. DATA: Inicializacion de insumos visuales
    void data() {
        panel = new QVBoxLayout(this);
        lblMsg = new QLabel("Ingrese un texto para la prueba:", this);
        txtEntrada = new QLineEdit(this);
        btnOk = new QPushButton("Aceptar", this);
    }

    // 3. PROCESO: Logica, configuracion y ensamble de componentes
    void proceso() {
        // Integrar activadores al contenedor
        panel->addWidget(lblMsg);
        panel->addWidget(txtEntrada);
        panel->addWidget(btnOk);
        
        // Configuracion del frame principal
        this->setLayout(panel);
        this->setWindowTitle("Ejercicio 8 Bis - C++ Qt");
        this->resize(350, 150);
        
        // Conectar activador (senal/evento de Qt)
        connect(btnOk, &QPushButton::clicked, this, &InterfazQt::accionBoton);
    }

    void accionBoton() {
        std::string texto = txtEntrada->text().toStdString();
        std::cout << "Boton presionado. Entrada: " << texto << std::endl;
    }

    // 4. RESULTADO: Salida estructural (despliegue de interfaz)
    void resultado() {
        this->show();
    }
};

// 5. NAVEGABILIDAD: Flujo principal y ciclo de eventos
int main(int argc, char *argv[]) {
    QApplication app(argc, argv);
    InterfazQt gui;
    
    gui.meta();
    gui.resultado();
    
    // app.exec() mantiene el programa en escucha de eventos de usuario
    return app.exec(); 
}