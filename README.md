# Banco 

Crea una aplicación que sirva para gestionar las cuentas de los clientes de un banco. 

## Beans

### Bank

Campos:
- Nombre del banco
- Array de cuentas.

Métodos:
- Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)
- Dado un IBAN, mostrar la información de la cuenta con ese IBAN. Si no existe una cuenta con ese IBAN devuelve null.
- Dado un NIF, mostrar todas las cuentas del cliente con ese NIF 
- Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN. Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"
- Dado un NIF , devuelve el numero de cuenta de ese cliente.
- Dado un IBAN devuelve los datos del cliente al que pertenece la cuenta . Si no existe devuelve null.


### Account

Campos:
- IBAN: String
- Saldo: double
- Cliente: customer

### Customer (cliente)

Campos:
- NIF
- Nombre
- Apellidos

## Componentes

### Readers

Crea readers para todos los beans

### BankApp

Tendrá un método run() que realice los siguiente:
- Pide los datos de un banco
- Inicia un bucle de menú con las siguientes opciones
  1. Mostrar las cuentas del banco
  2. Mostrar datos de una cuenta
     - Se pide un IBAN
     - Se busca la cuenta con ese IBAN.
     - Si no existe se muestra el mensaje "No existe la cuenta", si existe se muestra todo en pantall
  3. Mostrar los datos de las cuentas de un cliente
     - Se pide un nif
     - Se recorren las cuentas comprobando si son del cliente con ese nif. Se muestran en pantalla
  4. Ingresar dinero en cuenta
     - Se pide un IBAN
     - Se pide una cantidad de dinero
     - Se busca la cuenta con el IBAN. 
       - Si no existe se muestra el mensaje "No existe la cuenta"
       - Si existe se modifica el saldo, añadiendo la cantidad. 
       - Se muestra la cuenta
  5. Sacar diner de una cuenta
    - Se pide un IBAN
    - Se pide una cantidad de dinero
    - Se busca la cuenta con el IBAN.
        - Si no existe se muestra el mensaje "No existe la cuenta"
        - Si hay suficiente saldo, se reduce el saldo. Si no hay suficiente saldo se muestra "Saldo insuficiente"
        - Se muestra la cuenta

