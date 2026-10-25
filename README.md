# Mundo Car — proyecto HTML + estructura Maven para GitHub

Proyecto educativo inspirado en las 12 pantallas de Mundo Car. Sigue la estructura de carpetas que aparece en la captura de Visual Studio Code, con nombres adaptados a un taller automotriz.

## Ver las 12 pantallas sin instalar Java

Abre `src/main/resources/static/index.html` con Chrome, Edge o Firefox. La aplicación carga `css/estilos.css`, `js/app.js` y `img/mundocar-logo.png` usando rutas relativas.

- Menús: Administrador, Recepcionista, Mecánico y Almacén.
- Formularios: Usuarios, Clientes/Vehículos, Órdenes, Diagnóstico, Presupuesto, Inventario, Kardex, Reparación, Historial, Calidad y Pagos.
- Datos de demostración en `localStorage`. **El inicio de sesión y los roles no tienen seguridad real.**

## Ejecutar como aplicación Java Spring Boot

Necesitas **Java 17 o superior** y **Maven 3.9+**, además de conexión a Internet la primera vez para descargar dependencias.

1. Abre la carpeta `MundoCar-GitHub` en VS Code.
2. Abre una terminal en esa carpeta.
3. Ejecuta:

```bash
mvn spring-boot:run
```

4. Visita [http://localhost:8080](http://localhost:8080).

La aplicación se sincroniza con `/api/estado` si se sirve desde Spring Boot, y persiste los datos de demostración en una base H2 local dentro de `/data/`.

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/estado` | Recupera estado JSON; 204 si está vacío |
| PUT | `/api/estado` | Guarda estado JSON completo |
| GET | `/api/clientes` | Muestra lista de clientes |
| GET | `/api/vehiculos` | Muestra vehículos |
| GET | `/api/ordenes` | Muestra órdenes |
| GET | `/api/inventario` | Muestra repuestos |
| GET | `/api/usuarios` | Muestra usuarios |

Hay más rutas de consulta bajo `/api/diagnosticos`, `/api/presupuestos`, `/api/kardex`, `/api/reparaciones`, `/api/calidad`, `/api/pagos` y `/api/historial`. Las rutas de consulta son de solo lectura; los cambios desde el HTML usan `PUT /api/estado`.

## Subir a GitHub

No se subió el proyecto a una cuenta de GitHub automáticamente. Crea un repositorio **vacío** en [https://github.com/new](https://github.com/new) y reemplaza `TU_USUARIO` en los comandos siguientes:

```bash
git init
git add .
git commit -m "Primera versión de Mundo Car"
git branch -M main
git remote add origin https://github.com/TU_USUARIO/mundo-car.git
git push -u origin main
```

Si usas HTTPS, GitHub puede pedir que autentiques con su herramienta habitual, por ejemplo el administrador de credenciales de Git.

También puedes abrir el archivo `abrir-github.html` o pulsar el enlace de GitHub dentro de Mundo Car; ambos dirigen a la página para **crear un repositorio**, no publican archivos por sí solos.

## Estructura

```text
MundoCar-GitHub/
├── .github/workflows/maven.yml
├── .mvn/jvm.config
├── .vscode/settings.json, launch.json, extensions.json
├── src/
│   ├── main/
│   │   ├── java/com/mundocar/
│   │   │   ├── controller/       (13 controladores + Home)
│   │   │   ├── model/            (modelos de taller)
│   │   │   ├── repository/       (EstadoRepository)
│   │   │   ├── service/          (EstadoService)
│   │   │   └── MundoCarApplication.java
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── index.html
│   │       │   ├── css/estilos.css
│   │       │   ├── js/app.js
│   │       │   └── img/mundocar-logo.png
│   │       ├── templates/
│   │       └── application.properties
│   └── test/java/com/mundocar/MundoCarApplicationTests.java
├── .gitignore
├── pom.xml
├── abrir-github.html
└── README.md
```

## Aviso

**Es un prototipo académico, no una aplicación lista para uso público.** La pantalla de inicio de sesión acepta cualquier correo válido y contraseña no vacía. No existe autenticación ni autorización en el servidor; la API y la base H2 no deben estar expuestas a Internet. Antes de usar datos reales hay que implementar controles de seguridad, copias de seguridad y validaciones por entidad.
