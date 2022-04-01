# Calculadora2022ConInterfaz

Se ha realizado la implementacion de la interfaz de la clase `Calculadora` realizada en ejercicios anteriores.
Para ello, se ha empleado una cola en la cual iremos almacenando los numeros y las operaciones del usuario.


Las operacioces se realizar�n de manera secuencial, es decir, para la operacion `3+5-2/2` se realizar�:

3 + 5 = 8
8 - 2 = 6
6 / 2 = 3

Luego para `3+5-2/2` el resultado ser� 3

Debemos destacar tambi�n que en esta calculadora no ser� posible empezar a escribir directamente una operaci�n (a excepci�n del menos, el cual indicar� que estamos a�adiendo un valor negativo) y tampoco ser� posible determinar realizar diferentes operaciones donde intervengan tambi�n El m�todo `esPrimo` y `factorial` ya que estos m�todos de la clase `Calculadora` solo aceptan numeros enteros, y en cambio, para las +-*/ usamos valores reales, no ser� posible realizar estos c�lculos de golpe en una �nica secuencia como `3+5-2/2P`.

Para determinar si un n�mero es primo o para conocer el factorial, deberemos introducir dicho n�mero en la calculadora, pulsar en la tecla correspodiente a la operaci�n y luego pulsar el igual.