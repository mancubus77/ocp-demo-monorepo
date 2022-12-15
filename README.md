# OpenShift Application deployment Demo

This is Simple demo of OpenShift capabilities for Application deployment. The solution demonstrates how OpenShift can build, deploy and run application written in different languages. 

### Components
**Frontend**
NodeJS 

**Backends**
Python
Golang
Rust
Quarkus

## Installation
```
oc new-project monorepo
oc apply -k kubernetes/base
```

## Build 
Openshift checks out application from Git repository, build containers using BuildConfig and deploys them on OCP Cluster.

## Usage
Deploy kustomize and use browser to open frontend. On every page refresh frontend polls backends in round-robin.

## Advanced Usage
Branch "mem-bomb" has a bug in golang code what allocates memory with each access. Therefore after a few connections to this backend it killed by OCP with rasing OOM exception. This is to demonstrate limits of Kube