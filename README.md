#PokeJava

PokeJava es un port a Java del antiguo simulador de batallas pokemon "poketty".

#¿Qué características aún faltan en esta versión?

En comparación con Poketty, PokeJava aún no incorpora un modo contra la CPU, además la consola tampoco colorea palabras clave.

#¿Por qué se han eliminado los colores en PokeJava?

No he encontrado una forma sencilla y portable de colorear la consola en Java.

#¿Como cargo mis propios pokemons?

PokeJava funciona con ficheros .pkm, con una sintaxis de "clave=valor" donde se guardan los atributos de cada pokemon, así como sus ataques.

```
#El nombre del pokemon
nombre=pikachu
#pociones que tiene el pokemon
pociones=2
#antidotos que tiene el pokemon
antidotos=2

#pp son las veces que puedes usar el ataque
#pdMax el maximo daño que realizará el ataque
#pdMin el minimo daño que realizará el ataque
#estado indica que en el caso de que no sea "" paralizará al pokemon enemigo

#propiedades del primer ataque
ataque1_nombre=placaje
ataque1_pp=12
ataque1_pdMax=14
ataque1_pdMin=4
ataque1_estado=""

#propiedades del segundo ataque
ataque2_nombre=rayoElectrico
ataque2_pp=7
ataque2_pdMax=25
ataque2_pdMin=15
ataque2_estado=paralizado

#propiedades del tercer ataque
ataque3_nombre=relampago
ataque3_pp=10
ataque3_pdMax=20
ataque3_pdMin=10
ataque3_estado=""

#propiedades del cuarto ataque
ataque4_nombre=golpe de furia
ataque4_pp=6
ataque4_pdMax=30
ataque4_pdMin=4
ataque4_estado=""
```

En estado, podemos poner lo que queramos que aparecerá como estado en el pokemon enemigo, paralizandolo, en caso de que no queramos que el ataque produzca un estado, simplemente ponemos ""
Es importante que el estado de cada ataque tenga al menos "" después del igual, si lo dejamos vacio el juego no funcionará y dará error.

Nótese que puedes usar "#" para escribir comentarios

#¿Qué comandos puedo usar en PokeJava?

atacar: Ataca al pokemon enemigo, te pide seleccionar un ataque
pocion: Cura al pokemon si tienes pociones
antidoto: Vuelve el estado del pokemon a la normalidad
información: Despliega información de la partida
ayuda: Despliega la ayuda del juego
exit: Cancela la partida

#¿Qué licencia usa?

PokeJava está liberado bajo la licencia GPLv2, siéntete libre de modificarlo y aprender tanto como he aprendido yo escribíendolo.
