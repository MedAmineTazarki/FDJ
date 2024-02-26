# Android Clean Architecture with Jetpack Compose and Hilt

Ce projet est un exemple d'application Android qui utilise l'architecture propre avec Jetpack Compose pour la couche de présentation et Hilt pour l'injection de dépendances.

## Introduction

Ce projet démontre comment mettre en œuvre l'architecture propre dans une application Android moderne. Jetpack Compose est utilisé comme framework de développement d'interface utilisateur, offrant une approche déclarative pour la création d'UI. Hilt est choisi comme framework d'injection de dépendances en raison de sa compatibilité native avec les composants Android et de sa facilité d'intégration avec les applications Jetpack.

## Structure du Projet

Le projet est structuré en plusieurs modules :

### 1. Presentation

Ce module contient les éléments de l'interface utilisateur de l'application, tels que les écrans, les widgets, etc., implémentés avec Jetpack Compose. Jetpack Compose permet une gestion plus efficace de l'interface utilisateur grâce à son approche déclarative et à sa capacité à gérer automatiquement l'état.

### 2. Domain

Le module Domain contient les entités métier de l'application ainsi que les cas d'utilisation (use cases). Cette couche représente le cœur fonctionnel de l'application et est totalement indépendante des détails de mise en œuvre.

### 3. Data

Ce module est responsable de la récupération et du stockage des données nécessaires à l'application. Il inclut les sources de données, telles que les API distantes, les bases de données locales, etc. Il fournit également les implémentations des répertoires utilisés par la couche Domain.

### 4. Injection de Dépendances

Ce module centralise la configuration de l'injection de dépendances à l'aide de Hilt. Hilt simplifie l'injection de dépendances dans les applications Android en générant automatiquement le code nécessaire à la création et à l'injection d'objets. Il offre une intégration native avec les composants Android, ce qui facilite son utilisation dans les applications Jetpack Compose.

## Technologies Utilisées

- Kotlin
- Jetpack Compose
- Hilt (pour l'injection de dépendances)
- Kotlin Coroutines
- Retrofit (pour les appels réseau)