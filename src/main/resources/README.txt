El archivo de util se ejecuta una sola vez al inicio y guarda los 3 tipos del producto al inicio

Los requisitos estan separados entre ambas entities

-Catalogo: buscar por el nombre, eliminar por el nombre, dato string
-Producto: Numerico, booleano, fecha

Ambos tienen metodo select all
Ambos insert
El puerto esta cambiado en el perfil dev

URL swagger: http://localhost:8007/swagger-ui/index.html

JSON Catalogo
{
  "id": 1,
  "nombre": "EJEMPLO_ENUM"
}

JSON Producto
{
  "id": 1,
  "fechaRegistro": "2023-05-21T15:30:00",
  "precio": 99.99,
  "estado": true,
  "catalogo": {
    "id": 1,
    "nombre": "EJEMPLO_ENUM"
  }
}
