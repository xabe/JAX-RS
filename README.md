JBoss JAX-RS
======================

Este ejemplo muestra como conectarse a un JAX-RS remotamente que esta desplegando en un Jboss 6.1 EAP, Este ejemplo utiliza Jersey y EasyRest para implementar JAX-RS,
implementa el client como el servidor.

Ejecutar el ejemplo
-------------------
		
Contruimos el WAR que contiene el servicio Rest
		
		cd JbossRestServer
        mvn clean package	
		
Despues desplegamos el ear en nuestro JBoss 6.1 EAP

		cp target/JbossRestServer.war JBOSS_HOME/standalone/deployments

Por ultimo ejecutamos el cliente:
		
		cd JbossRestClient
		mvn clean package exec:exec