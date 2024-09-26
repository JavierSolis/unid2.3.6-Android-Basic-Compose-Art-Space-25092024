<img src="android_compose_head.png" alt="android jetpack compose android basics" style="width:100%;"/>

# Courses Android Compose Basic - Solution Code #AndroidBasics

# Training > Android Basics with Compose > Building App UI > UI and state > 6/Art Space

---

Solution code for the Android Basics with Compose

Exercise source: https://developer.android.com/codelabs/basic-android-kotlin-compose-art-space?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-art-space#0

# Description

------------

## [1\. Antes de comenzar](https://developer.android.com/codelabs/basic-android-kotlin-compose-art-space?hl=es-419&continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-2-pathway-3%3Fhl%3Des-419%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-art-space#0)

Aplica lo que aprendiste en esta unidad para crear tu propio espacio de arte digital: una app que exhibe una variedad de obras de arte que puedes mostrar. A diferencia de los codelabs anteriores, en los que se te proporcionaron instrucciones paso a paso para seguir, aquí solo se proporcionan lineamientos y sugerencias sobre lo que puedes crear con los conceptos que aprendiste hasta ahora. Te recomendamos que uses la creatividad para compilar la app de forma independiente, con lineamientos limitados.

Compilar una app por tu cuenta representa un desafío, pero no te preocupes porque ya practicaste lo suficiente. Puedes utilizar las mismas habilidades que aprendiste en este nuevo contexto. En cualquier momento, puedes consultar los codelabs anteriores si no sabes bien cómo implementar ciertas partes de la app.

Cuando compilas esta app por tu cuenta y resuelves los problemas que enfrentas en el proceso, aprendes más rápido y retienes los conceptos por más tiempo. Como beneficio adicional, la app es completamente personalizada, así que puedes usarla para exhibir tu creación como parte de tu porfolio de desarrollador.

Advertencia: No uses elementos que no te pertenezcan o de los que no tengas los derechos adecuados para usar en tu app.

## Requisitos previos

*   Capacidad de crear y ejecutar un proyecto en Android Studio
*   Experiencia con la sintaxis de Kotlin, incluidas las expresiones `Boolean` y `when`
*   Capacidad para aplicar conceptos básicos de Jetpack Compose, como el uso del estado con el objeto `MutableState`
*   Experiencia con funciones componibles, incluidos los elementos `Text`, `Image` y `Button`

## Qué aprenderás

*   Cómo compilar prototipos de baja fidelidad y traducirlos al código
*   Cómo compilar diseños simples con los elementos `Row` y `Column` componibles, y organizarlos con los parámetros `horizontalAlignment` y `verticalArrangement`
*   Cómo personalizar elementos de Compose con un objeto `Modifier`
*   Cómo identificar estados y modificarlos sobre activadores, como presionar botones

## Qué compilarás

*   Una app para Android que puede mostrar obras de arte o fotos familiares

## Requisitos

*   Una computadora que tenga Android Studio instalado
*   Fotos o arte digital para mostrar en la app

A continuación, se muestra un ejemplo del aspecto que podría tener tu app al final de este proyecto:

![fd250028b87ec08f.png](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-art-space/img/fd250028b87ec08f.png?hl=es-419)

_Muestra de la app de Art Space, que muestra una colección seleccionada de material gráfico enmarcado del equipo de capacitación de Aspectos básicos de Android._