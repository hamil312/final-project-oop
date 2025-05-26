# Servicio de Consultas Médicas para Sistema Clínico

### ***Hamilton Santiago Insandara Alvarez y Mario Fernando Santacruz Pantoja***
### *Programación Orientada a Objetos*

## Descripción del Servicio

Se trata del backend o API de un microservicio de consultas para un sistema de administración clínico construido utilizando el framework Spring de Java 17 y utilizando una base de datos MySQL,es un CRUD que cuenta con las siguientes operaciones.

- GET /consultas &rarr; Obtener todas las consultas médicas creadas
- GET /consultas/{id} &rarr; Obtener una consulta médica en específico a través de su ID
- POST /consultas &rarr; Crear una consulta médica
- GET /consultas/cita/{citaId} &rarr; Obtener una consulta en específico a través del ID de su cita
- GET /consultas/paciente/{pacienteId} &rarr; Obtener una consulta en específico a través del ID del paciente
- GET /consultas/diagnostico-frecuente &rarr; Obtener el diagnóstico más frecuente entre las consultas creadas
- GET /consultas/diagnostico-frecuente-fecha? &rarr; Obtiene el diagnóstico más frecuente entre las consultas creadas en un determinado periodo de tiempo

##  Consultas

A continucación se muestran ejemplos de consultas REST que se pueden realizar al sistema

### GET /consultas
Local
```cmd
curl --location 'http://localhost:8080/consulta'
```
Despliegue
```cmd
curl --location 'https://final-project-oop-production.up.railway.app/consulta'
```

### GET /consultas/{id}
Local
```cmd
curl --location 'http://localhost:8080/consulta/1'
```
Despliegue
```cmd
curl --location 'https://final-project-oop-production.up.railway.app/consulta/1'
```

### POST /consultas
Local
```cmd
curl --location 'http://localhost:8080/consulta' --header 'Content-Type: application/json' --data '{"diagnosis": "Covid2","prescription": "Paracetamol 1","observations": "Ninguna","appointmentId": 12}'
```
Despliegue
```cmd
curl --location 'https://final-project-oop-production.up.railway.app/consulta' --header 'Content-Type: application/json' --data '{"diagnosis": "Covid2","prescription": "Paracetamol 1","observations": "Ninguna","appointmentId": 1}'
```

### GET /consultas/cita/{citaId}
Local
```cmd
curl --location 'http://localhost:8080/consulta/cita/10'
```
Despliegue
```cmd
curl --location 'https://final-project-oop-production.up.railway.app/consulta/cita/1'
```

### GET /consultas/paciente/{pacienteId}
Local
```cmd
curl --location 'http://localhost:8080/consulta/paciente/1'
```
Despliegue
```cmd
curl --location 'https://final-project-oop-production.up.railway.app/consulta/paciente/1'
```

### GET /consultas/diagnostico-frecuente
Local
```cmd
curl --location 'http://localhost:8080/consulta/diagnostico-frecuente'
```
Despliegue
```cmd
curl --location 'https://final-project-oop-production.up.railway.app/consulta/diagnostico-frecuente'
```

### GET /consulta/diagnostico-frecuente-fecha?
Local
```cmd
curl --location 'http://localhost:8080/consulta/diagnostico-frecuente-fecha?fechaInicio=2005-12-12&fechaFin=2007-12-12'
```
Despliegue
```cmd
curl --location 'https://final-project-oop-production.up.railway.app/consulta/diagnostico-frecuente-fecha?fechaInicio=2005-12-12&fechaFin=2007-12-12'
```

## Repositorio

[Puede encontrar el repositorio aquí](https://github.com/hamil312/final-project-oop)

## URL de Despliegue

[Este repositorio está desplegado en Railway](https://final-project-oop-production.up.railway.app/)
