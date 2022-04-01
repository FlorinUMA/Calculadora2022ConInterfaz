# Calculadora2022ConInterfaz

Se ha realizado la implementacion de la interfaz de la clase `Calculadora` realizada en ejercicios anteriores.
Para ello, se ha empleado una cola en la cual iremos almacenando los numeros y las operaciones del usuario.


Las operacioces se realizarán de manera secuencial, es decir, para la operacion `3+5-2/2` se realizará:

3 + 5 = 8
8 - 2 = 6
6 / 2 = 3

Luego para `3+5-2/2` el resultado será 3

Debemos destacar también que en esta calculadora no será posible empezar a escribir directamente una operación (a excepción del menos, el cual indicará que estamos añadiendo un valor negativo) y tampoco será posible determinar realizar diferentes operaciones donde intervengan también El método `esPrimo` y `factorial` ya que estos métodos de la clase `Calculadora` solo aceptan numeros enteros, y en cambio, para las +-*/ usamos valores reales, no será posible realizar estos cálculos de golpe en una única secuencia como `3+5-2/2P`.

Para determinar si un número es primo o para conocer el factorial, deberemos introducir dicho número en la calculadora, pulsar en la tecla correspodiente a la operación y luego pulsar el igual.