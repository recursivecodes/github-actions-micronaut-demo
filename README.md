# github-actions-micronaut-demo

![micronaut-ci-demo](https://github.com/recursivecodes/github-actions-micronaut-demo/workflows/micronaut-ci-demo/badge.svg)

## Create App

```bash
mn create-app codes.recursive.github-actions-micronaut-demo
```

## Create Controller 

```bash
mn create-controller HelloController 
```

## Create Test


## Micronaut Data

* Annotation added to `Application.java`
* Gradle dependencies added
* Datasource created an `application.yml`
* Create Entity
* Create Repo
* Create Bootstrap
* Add liquibase dependency
    * Create changelog
    * Add change set to create user table
* Add Oracle Testcontainer dependency
* Build Oracle DB XE Image:
    * https://github.com/oracle/docker-images/tree/master/OracleDatabase/SingleInstance/dockerfiles
* Tag & Push To OCIR
* Point test container at OCIR image